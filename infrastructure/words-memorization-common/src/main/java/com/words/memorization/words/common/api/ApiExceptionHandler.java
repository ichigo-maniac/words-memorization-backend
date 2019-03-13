package com.words.memorization.words.common.api;

import com.words.memorization.words.common.exceptions.BadRequestException;
import com.words.memorization.words.common.exceptions.BusinessException;
import com.words.memorization.words.common.exceptions.ResourceNotFoundException;
import com.words.memorization.words.common.models.Output;
import com.words.memorization.words.common.models.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice(basePackageClasses = ApiBase.class)
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static Error makeError(BusinessException ex) {
        return ex != null ? new Error(ex.getCode(), ex.getMessage(), ex.getDetails()) : null;
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<?> handleBusinessException(BusinessException ex, WebRequest request) {
        Error error = makeError(ex);
        log.error(error.toString(), ex);
        return createResponse(Collections.singletonList(error), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Incorrect value";
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException e = (MethodArgumentTypeMismatchException) ex;
            message = "Incorrect param's value " + e.getName();
        }
        Error error = new Error("V000", message, ex.toString());
        log.error(error.toString(), ex);

        Output output = new Output();
        output.setErrors(Collections.singletonList(error));
        return new ResponseEntity<>(output, HttpStatus.BAD_REQUEST);
    }

    private List<Error> mapBindErrors(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.add(new Error("V000", error.getField(), error.getDefaultMessage()));
        }
        for (ObjectError error : bindingResult.getGlobalErrors()) {
            errors.add(new Error("V000", error.getObjectName(), error.getDefaultMessage()));
        }
        return errors;
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Output output = new Output();
        output.setErrors(mapBindErrors(ex.getBindingResult()));
        return new ResponseEntity<>(output, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Error fault = new Error("E000", ex.getLocalizedMessage(), ex.toString());
        Output output = new Output();
        output.setErrors(Collections.singletonList(fault));
        return super.handleExceptionInternal(ex, output, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        Output output = new Output();
        output.setErrors(mapBindErrors(ex.getBindingResult()));
        return new ResponseEntity<>(output, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<Error> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(new Error("V000", violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return createResponse(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleAnyException(Exception ex, WebRequest request) {
        Error error = new Error("E000", "Internal error", ex.toString());
        log.error(error.toString(), ex);
        return createResponse(Collections.singletonList(error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Error error = new Error(ex.getErrorCode(), "Resource has not been found", ex.getMessage());
        log.error(error.toString(), ex);
        return createResponse(Collections.singletonList(error), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> handleBadRequestException(BadRequestException ex) {
        Error error = new Error(ex.getErrorCode(), "Bad request error", ex.getMessage());
        log.error(error.toString(), ex);
        return createResponse(Collections.singletonList(error), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<?> createResponse(List<Error> errors, HttpStatus status) {
        Output output = new Output();
        output.setErrors(errors);
        return new ResponseEntity<>(output, status);
    }


}
