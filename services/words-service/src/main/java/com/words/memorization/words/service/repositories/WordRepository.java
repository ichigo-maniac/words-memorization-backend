package com.words.memorization.words.service.repositories;

import com.words.memorization.words.service.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface WordRepository extends JpaRepository<WordEntity, UUID>, JpaSpecificationExecutor<WordEntity> {

    @Query("SELECT word FROM Word as word " +
            "WHERE word.displayText = :displayText")
    Optional<WordEntity> getWordByDisplayText(@Param("displayText") String displayText);

    Boolean existsByDisplayText(String displayText);

}
