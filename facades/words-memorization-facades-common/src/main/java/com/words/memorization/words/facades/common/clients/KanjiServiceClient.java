package com.words.memorization.words.facades.common.clients;

import com.words.memorization.words.facades.common.dto.KanjiDto;
import com.words.memorization.words.facades.common.models.PostKanjiModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient("words-service")
public interface KanjiServiceClient {

    @GetMapping("/api/kanji/by_display_text/{displayText}")
    KanjiDto getKanjiByDisplayText(@PathVariable("displayText") String displayText);

    @PostMapping(value = "/api/kanji")
    KanjiDto createKanji(@RequestBody PostKanjiModel postKanjiModel);

}
