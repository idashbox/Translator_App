package org.example.translator_app.models;

import lombok.Data;

@Data
public class TranslationResponse {
    private String translatedText;

    public TranslationResponse(String translatedText) {
        this.translatedText = translatedText;
    }
}

