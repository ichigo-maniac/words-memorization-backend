package com.words.memorization.words.service.repositories;

import com.words.memorization.words.service.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface WordRepository extends JpaRepository<WordEntity, UUID> {
}
