package com.words.memorization.words.service.entities;

import com.words.memorization.common.services.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Kanji's on value entity class
 */
@Entity(name = "OnKanjiValue")
@Table(name = "on_kanji_values")
@Getter
@Setter
public class OnKanjiValueEntity extends AbstractEntity {

    /**
     * Display text
     */
    @Column(name = "display_text", nullable = false)
    private String displayText;

    /**
     * Parent kanji
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kanji_id", referencedColumnName = "id", nullable = false)
    private KanjiEntity kanji;

}
