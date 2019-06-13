package com.words.memorization.words.facades.common.clients;

import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.facades.common.dto.WordDto;
import com.words.memorization.words.facades.common.enums.JLPTLevel;
import com.words.memorization.words.facades.common.models.PostWordModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient("words-service")
public interface WordsServiceClient {

    @GetMapping("/api/words/by_display_text/{displayText}")
    WordDto getWordByDisplayText(@PathVariable("displayText") String displayText);

    @GetMapping("/api/words/{wordId}")
    WordDto getWordById(@PathVariable("wordId") UUID wordId);

    @GetMapping("/api/words/words_list")
    PagedOutput<WordDto> getWordsList(@RequestParam("page") Integer page,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("jlptLevel") JLPTLevel jlptLevel);

    @PostMapping("/api/words")
    WordDto createWord(@RequestBody PostWordModel postWordModel);

}
