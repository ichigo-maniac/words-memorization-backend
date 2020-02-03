package com.words.memorization.connector.words.service.clients;

import com.words.memorization.connector.words.service.dto.WordDto;
import com.words.memorization.connector.words.service.enums.JLPTLevel;
import com.words.memorization.connector.words.service.models.PostWordModel;
import com.words.memorization.words.common.models.PagedOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient("words-service")
public interface WordsServiceClient {

    @GetMapping("/api/words/by_display_text/{displayText}")
    WordDto getWordByDisplayText(@PathVariable("displayText") String displayText);

    @GetMapping("/api/words/exists_by_display_text/{displayText}")
    Boolean wordExistsByDisplayText(@PathVariable("displayText") String displayText);

    @GetMapping("/api/words/{wordId}")
    WordDto getWordById(@PathVariable("wordId") UUID wordId);

    @GetMapping("/api/words/words_list")
    PagedOutput<WordDto> getWordsList(@RequestParam("page") Integer page,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("jlptLevel") JLPTLevel jlptLevel);

    @PostMapping("/api/words")
    WordDto createWord(@RequestBody PostWordModel postWordModel);

}
