package org.example.translator_app.services;

import org.example.translator_app.models.TranslationRequest;
import org.example.translator_app.models.TranslationRequestDto;
import org.example.translator_app.models.TranslationResponse;
import org.example.translator_app.repositories.TranslationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TranslationService {

    private static final String MYMEMORY_API_URL = "https://api.mymemory.translated.net/get";

    @Autowired
    private TranslationRequestRepository repository;

    private final RestTemplate restTemplate = new RestTemplate();

    public TranslationResponse translate(TranslationRequestDto requestDto) {
        String translatedText = translateText(requestDto.getInputText(), requestDto.getSourceLang(), requestDto.getTargetLang());

        TranslationRequest request = new TranslationRequest();
        request.setIpAddress(requestDto.getIpAddress());
        request.setInputText(requestDto.getInputText());
        request.setSourceLang(requestDto.getSourceLang());
        request.setTargetLang(requestDto.getTargetLang());
        request.setTranslatedText(translatedText);

        repository.save(request);

        return new TranslationResponse(translatedText);
    }

    private String translateText(String text, String sourceLang, String targetLang) {
        try {
            String url = String.format("%s?q=%s&langpair=%s|%s", MYMEMORY_API_URL, text, sourceLang, targetLang);
            MyMemoryResponse response = restTemplate.getForObject(url, MyMemoryResponse.class);
            if (response != null && response.getResponseData() != null) {
                return response.getResponseData().getTranslatedText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    static class MyMemoryResponse {
        private ResponseData responseData;

        public ResponseData getResponseData() {
            return responseData;
        }

        public void setResponseData(ResponseData responseData) {
            this.responseData = responseData;
        }

        static class ResponseData {
            private String translatedText;

            public String getTranslatedText() {
                return translatedText;
            }

            public void setTranslatedText(String translatedText) {
                this.translatedText = translatedText;
            }
        }
    }
}




