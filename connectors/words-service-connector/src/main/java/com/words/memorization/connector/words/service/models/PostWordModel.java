package com.words.memorization.connector.words.service.models;

import com.words.memorization.connector.words.service.enums.JLPTLevel;
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
