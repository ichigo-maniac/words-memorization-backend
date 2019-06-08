package com.words.memorization.words.service.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.words.common.utils.PageableUtils;
import com.words.memorization.words.service.api.dto.KanjiDto;
import com.words.memorization.words.service.api.model.GetKanjiListInput;
import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.mapping.WordsMapper;
import com.words.memorization.words.service.services.KanjiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@Api(description = "Kanji operations API")
@RestController
@RequestMapping("/api/kanji")
public class KanjiApi extends ApiBase {

    @Autowired
    private KanjiService kanjiService;

    @Autowired
    private WordsMapper wordsMapper;

    @ApiOperation(value = "Search a kanji by display text")
    @GetMapping("/by_display_text/{displayText}")
    public KanjiDto getKanjiByDisplayText(@ApiParam(value = "Display text", example = "日")
                                          @PathVariable("displayText") String displayText) {
        return wordsMapper.toKanjiDto(kanjiService.getKanjiByDisplayText(displayText));
    }

    @ApiOperation(value = "Search a kanji by id")
    @GetMapping("/{kanjiId}")
    public KanjiDto getKanjiById(@ApiParam(value = "ID") @PathVariable("kanjiId") UUID kanjiId) {
        return wordsMapper.toKanjiDto(kanjiService.getKanjiById(kanjiId));
    }

    @ApiOperation(value = "Search kanji items")
    @GetMapping("/kanji_list")
    public PagedOutput<KanjiDto> getKanjiList(@Valid GetKanjiListInput getKanjiListInput, @Valid Paging paging) {
        Page<KanjiEntity> kanjiPage = kanjiService.getKanjiList(getKanjiListInput.getJlptLevel(),PageableUtils.makePageable(paging));
        return new PagedOutput<>(wordsMapper.toKanjiDtoList(kanjiPage.getContent()),
            paging.getPage(), kanjiPage.getTotalPages(), kanjiPage.getTotalElements());
    }

    @ApiOperation(value = "Create a new kanji")
    @PostMapping
    public KanjiDto createKanji(@RequestBody @Valid PostKanjiInput kanjiInput) {
        return wordsMapper.toKanjiDto(kanjiService.createKanji(kanjiInput));
    }

}
