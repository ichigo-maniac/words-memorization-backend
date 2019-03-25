package com.words.memorization.words.service.repositories;

import com.words.memorization.words.service.entities.KanjiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface KanjiRepository extends JpaRepository<KanjiEntity, UUID> {

    @Query("SELECT kanji FROM Kanji as kanji " +
            "LEFT JOIN FETCH kanji.onValues " +
            "LEFT JOIN FETCH kanji.kunValues " +
            "WHERE kanji.displayText = :displayText")
    KanjiEntity getKanjiByDisplayText(@Param("displayText") String displayText);

}
