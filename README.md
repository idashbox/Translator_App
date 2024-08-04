# Translation Service

## Описание

Веб-приложение для перевода набора слов с использованием MyMemory.

## Запуск приложения
Скачайте zip этого репозитория себе на устройство и запустите приложение через среду разработки, например IntelliJ Idea.

Или же выполните следующие действия в командной строке:
1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/idashbox/Translator_App
    ```

2. Перейдите в директорию проекта:
    ```bash
    cd путь_куда_сохранился_репозиторий (например, cd C:\Users\Huisan\IdeaProjects\Translator_App)
    ```

3. Запустите приложение:
    ```bash
    mvnw spring-boot:run
    ```
    
## Использование

Отправьте POST-запрос на `/api/translate` с телом запроса в формате JSON:

```json
{ "ipAddress": "127.0.0.1",
   "inputText": "Моя маленькая кошка Персик любит кушать и играться",
   "sourceLang": "ru",
   "targetLang": "en"
}
```
Можете также использовать приложение Postman, отправив ему следующий HTTP-метод POST следующим образом:
```json
curl -XPOST 'http://localhost:8080/api/translate' \
-H 'Content-Type: application/json' \
-d '{ "ipAddress": "127.0.0.1",
"inputText": "Hello! My name is Daria and I love Java",
"sourceLang": "en",
"targetLang": "ru"
}'
```
