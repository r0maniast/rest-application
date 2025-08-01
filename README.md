# Spring REST API

Учебное веб-приложение для управления сотрудниками через REST API.

## Автор

Кривцов Роман

## Технологии

- Java
- Spring Framework
- Spring MVC
- Spring ORM
- Hibernate
- PostgreSQL
- Maven
- JUnit5
- Jackson
- c3p0 (Connection Pool)
- Jakarta Servlet API

## Возможности

- REST API для управления сотрудниками (CRUD операции)
- Хранение данных в базе данных PostgreSQL

## API Endpoints

- `GET /api/employees` - получить список всех сотрудников
- `GET /api/employees/{id}` - получить сотрудника по ID
- `POST /api/employees` - создать нового сотрудника
- `PUT /api/employees` - обновить существующего сотрудника
- `DELETE /api/employees/{id}` - удалить сотрудника по ID

## Структура проекта

```
spring_course_rest/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── romankrivtsov/
│   │   │           └── spring/
│   │   │               └── rest/
│   │   │                   ├── configuration/
│   │   │                   │   ├── Config.java
│   │   │                   │   └── WebInitializer.java
│   │   │                   ├── controller/
│   │   │                   │   └── RESTController.java
│   │   │                   ├── dao/
│   │   │                   │   ├── EmployeeDAO.java
│   │   │                   │   └── EmployeeDAOImpl.java
│   │   │                   ├── entity/
│   │   │                   │   └── Employee.java
│   │   │                   ├── exception/
│   │   │                   │   ├── EmployeeGlobalExceptionHandler.java
│   │   │                   │   ├── EmployeeIncorrectData.java
│   │   │                   │   └── NotExistEmployeeException.java
│   │   │                   └── service/
│   │   │                       ├── EmployeeService.java
│   │   │                       └── EmployeeServiceImpl.java
│   │   ├── resources/
│   │   └── webapp/
│   │       └── WEB-INF/
│   └── test/
│       └── java/
│           └── com/
│               └── romankrivtsov/
│                   └── spring/
│                       └── rest/
```

## Архитектура

Проект построен по многослойной архитектуре:

- **Controller Layer** - REST контроллеры для обработки HTTP запросов
- **Service Layer** - бизнес-логика приложения
- **DAO Layer** - слой доступа к данным
- **Entity Layer** - модели данных (JPA сущности)
- **Exception Layer** - обработка исключений

## Настройка базы данных

Приложение использует PostgreSQL. Настройки подключения находятся в `Config.java`:

- URL: `jdbc:postgresql://localhost:5432/my_db`
- User: `postgres`
- Password: `postgres`

### Создание таблицы

Перед запуском приложения необходимо создать таблицу `employees` в базе данных `my_db`:

```sql
create table if not exists employees
(
    id         serial
        primary key,
    name       varchar(15),
    surname    varchar(25),
    department varchar(20),
    salary     integer
)
```

## Запуск проекта

1. Убедитесь, что PostgreSQL запущен и база данных `my_db` создана
2. Выполните команду для сборки проекта:
   ```bash
   mvn clean install
   ```
3. Разверните WAR файл в Tomcat или другом сервлет-контейнере

## Тестирование API

После запуска приложения можно тестировать API через любой HTTP клиент (Postman, curl, etc.):

```bash
# Получить всех сотрудников
curl -X GET http://localhost:8080/spring_course_rest/api/employees

# Создать нового сотрудника
curl -X POST http://localhost:8080/spring_course_rest/api/employees \
  -H "Content-Type: application/json" \
  -d '{"name":"John","surname":"Doe","department":"IT","salary":5000}'

# Получить сотрудника по ID
curl -X GET http://localhost:8080/spring_course_rest/api/employees/1

# Обновить сотрудника
curl -X PUT http://localhost:8080/spring_course_rest/api/employees \
  -H "Content-Type: application/json" \
  -d '{"id":1,"name":"John","surname":"Smith","department":"IT","salary":6000}'

# Удалить сотрудника
curl -X DELETE http://localhost:8080/spring_course_rest/api/employees/1
```

## Контакты

- Email: romankrivtsov7@gmail.com
- Telegram: [@romYUkd](https://t.me/romYUkd)
