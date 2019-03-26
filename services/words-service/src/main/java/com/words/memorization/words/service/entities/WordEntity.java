package com.words.memorization.words.service.entities;

import com.words.memorization.words.service.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Word's entity class
 */
@Entity(name = "Word")
@Table(name = "words")
@Getter @Setter
public class WordEntity extends AbstractEntity {

    /**
     * Display text
     */
    @Column(name = "display_text", nullable = false, unique = true)
    private String displayText;

    /**
     * JLPT level
     */
    @Column(name = "jlpt_level")
    @Enumerated(EnumType.STRING)
    private JLPTLevel jlptLevel;

    /**
     * Hiragana transcription
     */
    @Column(name = "hiragana_text", nullable = false)
    private String hiraganaText;

    /**
     * Eng translate
     */
    @Column(name = "en_translate")
    private String enTranslate;

    /**
     * Rus translate
     */
    @Column(name = "ru_translate")
    private String ruTranslate;

}
