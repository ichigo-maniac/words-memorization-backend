package com.words.memorization.words.facades.common.models;

import com.words.memorization.words.facades.common.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostKanjiModel {

    private JLPTLevel jlptLevel;

    private String displayText;

}
