Neoflex-test-task-java

Тестовое задание для учебного центра Neoflex, 2024

Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"

Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.

Запрос на API
Простой запрос:
http://localhost:8089/calculate?averageSalary=50000.00&vacationDays=30
Запрос с указанием точного дня ухода в отпуск:
http://localhost:8089/calculate?averageSalary=50000.00&vacationDays=30&startVacationDate=2025-03-19
Cтек проекта:
SpringBoot  
Maven
Java 17   
MySQL
Stream API   
jUnit   
MockMvc   

