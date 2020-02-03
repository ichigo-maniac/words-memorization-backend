package com.words.memorization.connector.words.service.models;

import com.words.memorization.connector.words.service.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class PostKanjiModel {

    private JLPTLevel jlptLevel;

    private String displayText;

    private List<PostOnKanjiValueModel> onValues;

    private List<PostKunKanjiValueModel> kunValues;

}
