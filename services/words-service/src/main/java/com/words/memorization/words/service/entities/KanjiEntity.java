package com.words.memorization.words.service.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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


}