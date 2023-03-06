[![Java](https://img.shields.io/badge/Java-E43222??style=for-the-badge&logo=java&logoColor=FFFFFF)](https://java.com/)
[![Spring Web](https://img.shields.io/badge/Spring_Web-FFFFFF??style=for-the-badge&logo=Spring)](https://spring.io/guides/gs/serving-web-content/)
[![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-FFFFFF??style=for-the-badge&logo=Spring)](https://spring.io/projects/spring-data-jpa)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-FFFFFF??style=for-the-badge&logo=Thymeleaf&logoColor=025B10)](https://www.thymeleaf.org/)
### Java version
Java 8 (18)
Java 17 (OpenJDK)

### Примеры GET-запросов
1. Страница приветствия http://localhost:8080/welcome
2. Вывод коллекции из всех автомобилей http://localhost:8080/cars
3. Вывод автомобиля с заданным ID http://localhost:8080/car?id=1

### Примеры POST-запросов (через Postman)
1. Добавить новый автомобиль http://localhost:8080/create
   Body (form-data): brand=bmw
                     color=Yellow  
2. Обновить автомобиль http://localhost:8080/update
   Body (form-data): id=1
                     brand=bmw
                     color=Yellow  
3. Удалить автомобиль http://localhost:8080/delete
   Body (form-data): id=1
