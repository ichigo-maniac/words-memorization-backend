package com.words.memorization.words.service.repositories;

import com.words.memorization.words.service.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface WordRepository extends JpaRepository<WordEntity, UUID> {

    @Query("SELECT word FROM Word as word " +
            "WHERE word.displayText = :displayText")
    WordEntity getWordByDisplayText(@Param("displayText") String displayText);

}
