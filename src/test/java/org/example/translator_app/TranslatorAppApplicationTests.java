package org.example.translator_app;

import org.example.translator_app.models.TranslationRequestDto;
import org.example.translator_app.models.TranslationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class TranslatorAppApplicationTests {

		@Autowired
		private RestTemplate restTemplate;

		@Test
		public void testLoad() throws InterruptedException {
			ExecutorService executorService = Executors.newFixedThreadPool(10);
			for (int i = 0; i < 20; i++) {
				executorService.submit(() -> {
					String url = "http://localhost:8080/api/translate";
					HttpHeaders headers = new HttpHeaders();
					headers.add("Content-Type", "application/json");

					TranslationRequestDto requestDto = new TranslationRequestDto();
					requestDto.setIpAddress("127.0.0.1");
					requestDto.setInputText("Hello world");
					requestDto.setSourceLang("en");
					requestDto.setTargetLang("ru");

					HttpEntity<TranslationRequestDto> request = new HttpEntity<>(requestDto, headers);
					ResponseEntity<TranslationResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, TranslationResponse.class);
					System.out.println(response.getBody().getTranslatedText());
				});
			}
			executorService.shutdown();
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		}

}
