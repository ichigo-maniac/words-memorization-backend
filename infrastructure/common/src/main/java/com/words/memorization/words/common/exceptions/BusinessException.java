package com.words.memorization.words.common.exceptions;

import org.springframework.util.StringUtils;

public class BusinessException extends RuntimeException {
    private final String code;
    private final String details;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.details = null;
    }

    public BusinessException(String code, String message, String details) {
        super(message);
        this.code = code;
        this.details = details;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.details = null;
    }

    public BusinessException(String code, String message, String details, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.details = details;
    }

    public BusinessException(BusinessError error) {
        this(error.getCode(), error.getDescription());
    }

    public BusinessException(BusinessError error, Throwable cause) {
        this(error.getCode(), error.getDescription(), cause);
    }

    public BusinessException(BusinessError error, String details) {
        this(error.getCode(), error.getDescription(), details);
    }

    public BusinessException(BusinessError error, String details, Throwable cause) {
        this(error.getCode(), error.getDescription(), details, cause);
    }

    public boolean isErrorCode(BusinessError error) {
        return (error == null && getCode() == null) || (error != null && error.getCode().equals(getCode()));
    }

    public String getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }

    public boolean hasDetails() {
        return !StringUtils.isEmpty(details);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(getClass().getSimpleName());
        if (getCode() != null) {
            result.append(" [").append(getCode()).append("]");
        }

        final String message = getLocalizedMessage();
        boolean hasMessage = !StringUtils.isEmpty(message);
        if (hasMessage) {
            result.append(": ").append(message);
        }
        if (hasDetails()) {
            result.append(" (").append(getDetails()).append(')');
        }
        return result.toString();
    }
}
