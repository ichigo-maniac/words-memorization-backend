package com.words.memorization.words.service.repositories;

import com.words.memorization.words.service.entities.KanjiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface KanjiRepository extends JpaRepository<KanjiEntity, UUID> {
}
