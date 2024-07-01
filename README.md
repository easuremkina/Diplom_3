# Diplom_3

# Запуск тестов в Yandex
Драйвер yandex лежит в src/test/resourses/
В файле src/test/resourses/config.properties прописать: browser=yandex
Запустить тесты:
```bash
mvn clean test
```

# Запуск тестов в Chrome
В файле src/test/resourses/config.properties прописать: browser=chrome
Запустить тесты:
```bash
mvn clean test
```

# Запуск отчёта allure:
```bash
mvn allure:serve
```
