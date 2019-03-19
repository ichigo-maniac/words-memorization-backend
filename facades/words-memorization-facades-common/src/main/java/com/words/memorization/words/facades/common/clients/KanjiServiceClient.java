package com.words.memorization.words.facades.common.clients;

import com.words.memorization.words.facades.common.models.PostKanjiModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient("words-service")
public interface KanjiServiceClient {

    @PostMapping(value = "/api/kanji", consumes = "application/json")
    UUID createKanji(@RequestBody PostKanjiModel postKanjiModel);

}
