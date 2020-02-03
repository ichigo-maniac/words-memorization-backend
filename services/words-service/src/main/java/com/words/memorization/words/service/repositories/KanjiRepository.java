package com.words.memorization.words.service.repositories;

import com.words.memorization.words.service.entities.KanjiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface KanjiRepository extends JpaRepository<KanjiEntity, UUID>, JpaSpecificationExecutor<KanjiEntity>  {

    @Query("SELECT kanji FROM Kanji as kanji " +
            "LEFT JOIN FETCH kanji.onValues " +
            "LEFT JOIN FETCH kanji.kunValues " +
            "WHERE kanji.displayText = :displayText")
    Optional<KanjiEntity> getKanjiByDisplayText(@Param("displayText") String displayText);

    @Query("SELECT kanji FROM Kanji as kanji " +
            "LEFT JOIN FETCH kanji.onValues " +
            "LEFT JOIN FETCH kanji.kunValues " +
            "WHERE kanji.id = :kanjiId")
    Optional<KanjiEntity> getKanjiById(@Param("kanjiId") UUID kanjiId);

    Boolean existsByDisplayText(String displayText);

}
