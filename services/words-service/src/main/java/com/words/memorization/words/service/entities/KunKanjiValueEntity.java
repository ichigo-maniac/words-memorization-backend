package com.words.memorization.words.service.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Kanji's kun value entity class
 */
@Entity(name = "KunKanjiValue")
@Table(name = "kun_kanji_values")
@Getter
@Setter
public class KunKanjiValueEntity extends AbstractEntity {

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
