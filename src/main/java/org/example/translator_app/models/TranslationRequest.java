package org.example.translator_app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("TRANSLATION_REQUESTS")
public class TranslationRequest {
    @Id
    private Long id;
    private String ipAddress;
    private String inputText;
    private String translatedText;
    private String sourceLang;
    private String targetLang;
}
