package com.words.memorization.words.management.facade.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.common.exceptions.ResourceNotFoundException;
import com.words.memorization.words.facades.common.dto.WordDto;
import com.words.memorization.words.management.facade.api.model.PostWordInput;
import com.words.memorization.words.management.facade.services.WordsClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "Words management operations API")
@RestController
@RequestMapping(ApiConfig.ROOT + "/words_management")
public class WordsManagementApi extends ApiBase {

    @Autowired
    private WordsClientService wordsClientService;

    @ApiOperation(value = "Search a word by display text")
    @GetMapping("/words/by_display_text/{displayText}")
    public WordDto getWordByDisplayText(@ApiParam(value = "Display text", example = "日本語")
                                          @PathVariable("displayText") String displayText) {
        WordDto word =  wordsClientService.getWordByDisplayText(displayText);
        if (word != null) {
            return word;
        } else {
            throw new ResourceNotFoundException("E000", "A word hasn't been found");
        }
    }

    @ApiOperation(value = "Create a new word")
    @PostMapping(value = "/words//word")
    public WordDto createWord(@Valid @RequestBody PostWordInput wordInput) {
        return wordsClientService.createWord(wordInput);
    }

}
