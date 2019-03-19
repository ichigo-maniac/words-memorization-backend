package com.words.memorization.words.management.facade.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import com.words.memorization.words.management.facade.services.KanjiClientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Api(description = "Kanji management operations API")
@RestController
@RequestMapping(ApiConfig.ROOT + "/kanji_management")
public class KanjiManagementApi extends ApiBase {

    @Autowired
    private KanjiClientService kanjiClientService;

    @PostMapping(value = "/kanji", consumes = "application/json")
    public UUID createKanji(@Valid @RequestBody PostKanjiInput kanjiInput) {
        return kanjiClientService.createKanji(kanjiInput);
    }


}
