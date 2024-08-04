package org.example.translator_app.controllers;

import org.example.translator_app.models.TranslationRequestDto;
import org.example.translator_app.models.TranslationResponse;
import org.example.translator_app.services.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/translate")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @PostMapping
    public ResponseEntity<TranslationResponse> translate(@RequestBody TranslationRequestDto request) {
        try {
            TranslationResponse response = translationService.translate(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TranslationResponse("Error occurred"));
        }
    }
}


