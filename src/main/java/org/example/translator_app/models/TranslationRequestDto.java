package org.example.translator_app.models;

import lombok.Data;

@Data
public class TranslationRequestDto {
    private String ipAddress;
    private String inputText;
    private String sourceLang;
    private String targetLang;
}




