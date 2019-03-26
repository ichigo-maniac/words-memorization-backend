package com.words.memorization.words.service.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
