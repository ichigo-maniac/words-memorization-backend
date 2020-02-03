package com.words.memorization.words.management.facade.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.common.exceptions.ResourceNotFoundException;
import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.connector.words.service.dto.KanjiDto;
import com.words.memorization.words.management.facade.api.model.GetKanjiListInput;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import com.words.memorization.words.management.facade.services.KanjiClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@Api(description = "Kanji management operations API")
@RestController
@RequestMapping(ApiConfig.ROOT + "/kanji_management")
public class KanjiManagementApi extends ApiBase {

    @Autowired
    private KanjiClientService kanjiClientService;

    @ApiOperation(value = "Search a kanji by display text")
    @GetMapping("/kanji/by_display_text/{displayText}")
    public KanjiDto getKanjiByDisplayText(@ApiParam(value = "Display text", example = "日")
                                          @PathVariable("displayText") String displayText) {
        return kanjiClientService.getKanjiByDisplayText(displayText);
    }

    @ApiOperation(value = "Search a kanji by id")
    @GetMapping("/kanji/{kanjiId}")
    public KanjiDto getKanjiById(@ApiParam(value = "ID") @PathVariable("kanjiId") UUID kanjiId) {
        return kanjiClientService.getKanjiById(kanjiId);
    }

    @ApiOperation(value = "Search kanji items")
    @GetMapping("/kanji/kanji_list")
    public PagedOutput<KanjiDto> getKanjiList(@Valid GetKanjiListInput getKanjiListInput, @Valid Paging paging) {
        return kanjiClientService.getKanjiList(getKanjiListInput.getJlptLevel(), paging);
    }

    @ApiOperation(value = "Create a new kanji")
    @PostMapping(value = "/kanji")
    public KanjiDto createKanji(@Valid @RequestBody PostKanjiInput kanjiInput) {
        return kanjiClientService.createKanji(kanjiInput);
    }

}
