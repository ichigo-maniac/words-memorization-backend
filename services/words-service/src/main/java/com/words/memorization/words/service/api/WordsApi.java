package com.words.memorization.words.service.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.service.api.dto.WordDto;
import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.mapping.WordsMapper;
import com.words.memorization.words.service.services.WordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Api(description = "Words operations API")
@RestController
@RequestMapping("/api/words")
public class WordsApi extends ApiBase {

    @Autowired
    private WordsService wordsService;

    @Autowired
    private WordsMapper wordsMapper;

    @ApiOperation(value = "Search a word by display text")
    @GetMapping("/by_display_text/{displayText}")
    public WordDto getWordByDisplayText(@ApiParam(value = "Display text", example = "日")
                                          @PathVariable("displayText") String displayText) {
        return wordsMapper.toWordDto(wordsService.getWordByDisplayText(displayText));
    }

    @ApiOperation(value = "Search a word by id")
    @GetMapping("/{wordId}")
    public WordDto getWordById(@ApiParam(value = "ID") @PathVariable("wordId") UUID wordId) {
        return wordsMapper.toWordDto(wordsService.getWordById(wordId));
    }

    @ApiOperation(value = "Create a new word")
    @PostMapping
    public WordDto createWords(@RequestBody @Valid PostWordInput wordInput) {
        return wordsMapper.toWordDto(wordsService.createWord(wordInput));
    }

}
