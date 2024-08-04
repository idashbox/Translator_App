package org.example.translator_app.repositories;

import org.example.translator_app.models.TranslationRequest;
import org.springframework.data.repository.CrudRepository;

public interface TranslationRequestRepository extends CrudRepository<TranslationRequest, Long> {
}

