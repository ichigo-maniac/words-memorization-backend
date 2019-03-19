package com.words.memorization.words.management.facade.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.facades.common.dto.KanjiDto;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import com.words.memorization.words.management.facade.services.KanjiClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Api(description = "Kanji management operations API")
@RestController
@RequestMapping(ApiConfig.ROOT + "/kanji_management")
public class KanjiManagementApi extends ApiBase {

    @Autowired
    private KanjiClientService kanjiClientService;

    @ApiOperation(value = "Search a kanji by display text")
    @GetMapping("/by_display_text/{displayText}")
    public KanjiDto getKanjiByDisplayText(@ApiParam(value = "Display text", example = "日")
                                          @PathVariable("displayText") String displayText) {
        return kanjiClientService.getKanjiByDisplayText(displayText);
    }

    @ApiOperation(value = "Create a new kanji")
    @PostMapping(value = "/kanji")
    public KanjiDto createKanji(@Valid @RequestBody PostKanjiInput kanjiInput) {
        return kanjiClientService.createKanji(kanjiInput);
    }

}
