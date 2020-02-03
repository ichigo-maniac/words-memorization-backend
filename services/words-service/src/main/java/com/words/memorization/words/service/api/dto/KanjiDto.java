package com.words.memorization.words.service.api.dto;

import com.words.memorization.words.service.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class KanjiDto extends AbstractDto {

    private String displayText;

    private JLPTLevel jlptLevel;

    private List<OnKanjiValueDto> onValues;

    private List<KunKanjiValueDto> kunValues;

}
