package com.words.memorization.words.facades.common.clients;

import com.words.memorization.words.facades.common.dto.WordDto;
import com.words.memorization.words.facades.common.models.PostWordModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("words-service")
public interface WordsServiceClient {

    @GetMapping("/api/words/by_display_text/{displayText}")
    WordDto getWordByDisplayText(@PathVariable("displayText") String displayText);

    @PostMapping(value = "/api/words")
    WordDto createWord(@RequestBody PostWordModel postWordModel);

}
