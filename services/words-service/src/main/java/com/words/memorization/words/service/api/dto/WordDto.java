package com.words.memorization.words.service.api.dto;

import com.words.memorization.words.service.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WordDto extends AbstractDto {

    private JLPTLevel jlptLevel;

    private String displayText;

    private String hiraganaText;

    private String enTranslate;

    private String ruTranslate;

}
