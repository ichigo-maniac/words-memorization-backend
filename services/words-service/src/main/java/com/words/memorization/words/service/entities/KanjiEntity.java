package com.words.memorization.words.service.entities;

import com.words.memorization.words.service.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Kanji entity class
 */
@Entity(name = "Kanji")
@Table(name = "kanji")
@Getter @Setter
public class KanjiEntity extends AbstractEntity {

    /**
     * Display text
     */
    @Column(name = "display_text", length = 10, nullable = false)
    private String displayText;

    /**
     * JLPT level
     */
    @Column(name = "jlpt_level")
    @Enumerated(EnumType.STRING)
    private JLPTLevel jlptLevel;


}
