# Приложение для создания списка контактов - contactList

## Функционал

### В проекте демонстрируется:

- разработка приложения с использованием Spring MVC и Spring Data JDBC;
- работа с базой данных в приложении через JdbcTemplate;
- создание простых интерфейсов пользователя через Thymeleaf;
- работа с Docker.

## Стек используемых технологий

- Spring Boot, Spring MVC и Spring Data JDBC для создания веб-приложения;
- Lombok для сокращения шаблонного кода;
- JdbcTemplate для работы с базой данных;
- Thymeleaf для создания простого интерфейса пользователя;
- Dockerfile для создания докер-образа и запуска контейнера в Docker.

## Инструкция по локальному запуску проекта

1) убедитесь, что на вашем ПК установлены IntelliJ IDEA и Docker Desktop;
2) клонируйте код приложения из репозитория командой:
```
git clone <https://github.com/NadezhdaJavaDeveloper/contact-list.git>
```
3) откройте проект с помощью IntelliJ IDEA;
4) откройте терминал;
5) перейдите в папку docker `cd docker`
6) отчистите старые контейнеры и тома (если есть) `docker-compose down -v`
7) запустите контейнер командой `docker-compose up --build`;
8) зайдите в браузер и введите в адресной строке `http://localhost:8080/`
9) нажмите кнопку:

- `Create contact` для создания контакта;
- `Edit` для редактирования контакта;
- `Delete` для удаления контакта.

