package com.words.memorization.words.service.entities;

import com.words.memorization.common.services.entities.AbstractEntity;
import com.words.memorization.words.service.enums.JLPTLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    @Column(name = "display_text", length = 10, nullable = false, unique = true)
    private String displayText;

    /**
     * JLPT level
     */
    @Column(name = "jlpt_level")
    @Enumerated(EnumType.STRING)
    private JLPTLevel jlptLevel;

    /**
     * On values
     */
    @OneToMany(mappedBy = "kanji", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OnKanjiValueEntity> onValues;

    /**
     * Kun values
     */
    @OneToMany(mappedBy = "kanji", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<KunKanjiValueEntity> kunValues;


}
