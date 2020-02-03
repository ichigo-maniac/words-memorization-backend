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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/kanji")
public class KanjiApi extends ApiBase {

    @Autowired
    private KanjiService kanjiService;

    @Autowired
    private WordsMapper wordsMapper;

    @GetMapping("/by_display_text/{displayText}")
    public KanjiDto getKanjiByDisplayText(@PathVariable("displayText") String displayText) {
        return wordsMapper.toKanjiDto(kanjiService.getKanjiByDisplayText(displayText));
    }

    @GetMapping("/exists_by_display_text/{displayText}")
    public Boolean kanjiExistsByDisplayText(@PathVariable("displayText") String displayText) {
        return kanjiService.kanjiExistsByDisplayText(displayText);
    }

    @GetMapping("/{kanjiId}")
    public KanjiDto getKanjiById(@PathVariable("kanjiId") UUID kanjiId) {
        return wordsMapper.toKanjiDto(kanjiService.getKanjiById(kanjiId));
    }

    @GetMapping("/kanji_list")
    public PagedOutput<KanjiDto> getKanjiList(@Valid GetKanjiListInput getKanjiListInput, @Valid Paging paging) {
        Page<KanjiEntity> kanjiPage = kanjiService.getKanjiList(getKanjiListInput.getJlptLevel(),PageableUtils.makePageable(paging));
        return new PagedOutput<>(wordsMapper.toKanjiDtoList(kanjiPage.getContent()),
            paging.getPage(), kanjiPage.getTotalPages(), kanjiPage.getTotalElements());
    }

    @PostMapping
    public KanjiDto createKanji(@RequestBody @Valid PostKanjiInput kanjiInput) {
        return wordsMapper.toKanjiDto(kanjiService.createKanji(kanjiInput));
    }

}
