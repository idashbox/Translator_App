CREATE TABLE TRANSLATION_REQUESTS (
                                      ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      IP_ADDRESS VARCHAR(255),
                                      INPUT_TEXT TEXT,
                                      TRANSLATED_TEXT TEXT,
                                      SOURCE_LANG VARCHAR(10),
                                      TARGET_LANG VARCHAR(10)
);

