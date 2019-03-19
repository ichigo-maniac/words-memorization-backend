package com.words.memorization.words.service.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.services.KanjiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Api(description = "Kanji operations API")
@RestController
@RequestMapping("/api/kanji")
public class KanjiApi extends ApiBase {

    @Autowired
    private KanjiService kanjiService;

    @PostMapping(consumes = "application/json")
    public UUID createKanji(@RequestBody @Valid PostKanjiInput kanjiInput) {
        KanjiEntity createdKanji = kanjiService.createKanji(kanjiInput);
        return createdKanji.getId();
    }


}
