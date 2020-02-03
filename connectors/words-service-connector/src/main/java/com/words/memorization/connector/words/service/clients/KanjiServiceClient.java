package com.words.memorization.connector.words.service.clients;

import com.words.memorization.connector.words.service.dto.KanjiDto;
import com.words.memorization.connector.words.service.enums.JLPTLevel;
import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.connector.words.service.models.PostKanjiModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@FeignClient("words-service")
public interface KanjiServiceClient {

    @GetMapping("/api/kanji/by_display_text/{displayText}")
    KanjiDto getKanjiByDisplayText(@PathVariable("displayText") String displayText);

    @GetMapping("/api/kanji/exists_by_display_text/{displayText}")
    Boolean kanjiExistsByDisplayText(@PathVariable("displayText") String displayText);

    @GetMapping("/api/kanji/{kanjiId}")
    KanjiDto getKanjiById(@PathVariable("kanjiId") UUID kanjiId);

    @GetMapping("/api/kanji/kanji_list")
    PagedOutput<KanjiDto> getKanjiList(@RequestParam("page") Integer page,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("jlptLevel") JLPTLevel jlptLevel);

    @PostMapping("/api/kanji")
    KanjiDto createKanji(@RequestBody PostKanjiModel postKanjiModel);

}
