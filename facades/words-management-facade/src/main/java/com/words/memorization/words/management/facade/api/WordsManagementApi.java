package com.words.memorization.words.management.facade.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.common.exceptions.ResourceNotFoundException;
import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.connector.words.service.dto.WordDto;
import com.words.memorization.words.management.facade.api.model.GetWordsListInput;
import com.words.memorization.words.management.facade.api.model.PostWordInput;
import com.words.memorization.words.management.facade.services.WordsClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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
        return wordsClientService.getWordByDisplayText(displayText);
    }

    @ApiOperation(value = "Search a word by id")
    @GetMapping("/words/{wordId}")
    public WordDto getWordById(@ApiParam(value = "ID") @PathVariable("wordId") UUID wordId) {
        return wordsClientService.getWordById(wordId);
    }

    @ApiOperation(value = "Search words")
    @GetMapping("/words/words_list")
    public PagedOutput<WordDto> getKanjiList(@Valid GetWordsListInput getWordsListInput, @Valid Paging paging) {
        return wordsClientService.getWordsList(getWordsListInput.getJlptLevel(), paging);
    }

    @ApiOperation(value = "Create a new word")
    @PostMapping(value = "/words//word")
    public WordDto createWord(@Valid @RequestBody PostWordInput wordInput) {
        return wordsClientService.createWord(wordInput);
    }

}
