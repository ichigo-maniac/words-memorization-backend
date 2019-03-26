package com.words.memorization.words.facades.common.models;

import com.words.memorization.words.facades.common.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostWordModel {

    private JLPTLevel jlptLevel;

    private String displayText;

    private String hiraganaText;

    private String enTranslate;

    private String ruTranslate;

}
