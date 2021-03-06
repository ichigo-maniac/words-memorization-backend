package com.words.memorization.words.service.api;

import com.words.memorization.words.common.api.ApiBase;
import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.words.common.utils.PageableUtils;
import com.words.memorization.words.service.api.dto.WordDto;
import com.words.memorization.words.service.api.model.GetWordsListInput;
import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.WordEntity;
import com.words.memorization.words.service.mapping.WordsMapper;
import com.words.memorization.words.service.services.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/words")
public class WordsApi extends ApiBase {

    @Autowired
    private WordsService wordsService;

    @Autowired
    private WordsMapper wordsMapper;

    @GetMapping("/by_display_text/{displayText}")
    public WordDto getWordByDisplayText(@PathVariable("displayText") String displayText) {
        return wordsMapper.toWordDto(wordsService.getWordByDisplayText(displayText));
    }

    @GetMapping("/exists_by_display_text/{displayText}")
    public Boolean wordExistsByDisplayText(@PathVariable("displayText") String displayText) {
        return wordsService.wordExistsByDisplayText(displayText);
    }

    @GetMapping("/{wordId}")
    public WordDto getWordById(@PathVariable("wordId") UUID wordId) {
        return wordsMapper.toWordDto(wordsService.getWordById(wordId));
    }

    @GetMapping("/words_list")
    public PagedOutput<WordDto> getWordsList(@Valid GetWordsListInput getWordsListInput, @Valid Paging paging) {
        Page<WordEntity> wordsPage = wordsService.getWordsList(getWordsListInput.getJlptLevel(), PageableUtils.makePageable(paging));
        return new PagedOutput<>(wordsMapper.toWordDtoList(wordsPage.getContent()),
                paging.getPage(), wordsPage.getTotalPages(), wordsPage.getTotalElements());
    }

    @PostMapping
    public WordDto createWords(@RequestBody @Valid PostWordInput wordInput) {
        return wordsMapper.toWordDto(wordsService.createWord(wordInput));
    }

}
