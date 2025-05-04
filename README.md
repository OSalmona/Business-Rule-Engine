<p align="center">
    <h1 align="center">Business Rule Engine</h1>
</p>
<p align="center">
    <em> 📖 This repo is for implement simple spring application for simulate transaction processing according to predefined business rule</em>
  </br>
</p>

---

## 📍 Project Requirments
- Spring boot version 3.4.5
- Java version 17
- Docker Engine
  
## 📍 How to install 
- downlod project from this repo
- or git clone https://github.com/OSalmona/Business-Rule-Engine.git

## 📍 How to Run application by Docker
- We should have a docker engine installed in our machine
- run command : docker build -t bre_image .
- run command : docker run -p 8080:8080 bre_image
- Now We Can access Our end points through postman 
- data base created automaticaaly when project run 

## 📍 How to Run application in our macine
- application run on server port 8080 so it will be http://localhost:8080
- data base created automaticaaly when project run 
      - http://localhost:8080/h2-console </br>
      - username : sa </br>
      - password : </br>
  
## 📍 Project Properties
- Database : H2 database
- Server Port : 8080
- spring.h2.console.path=/h2-console
- spring.datasource.url=jdbc:h2:mem:banquemisrDB
- spring.datasource.password=
---

## 📍 Project Features
- create business rule
- update business rule
- delete business rule
- get all business rule
- transaction preocess
---
## 📍 example :: create new Business Rule
- create business rule
  ![image](https://github.com/user-attachments/assets/397ada79-fb44-4124-b601-eb3837a40827)
- update business rule
  ![image](https://github.com/user-attachments/assets/8458a36b-b5bb-4f52-912b-e5aeb71d392e)
- delete business rule
  ![image](https://github.com/user-attachments/assets/15a873d4-66ba-4fcb-b2c5-bced95dea6c5)
- get all business rule
  ![image](https://github.com/user-attachments/assets/a635c9de-7181-45e3-8ea4-60c0e0ae66ff)
- transaction preocess
  ![image](https://github.com/user-attachments/assets/c693f5f4-5589-4106-92a2-d8a6f24787b2)
---

## 📍 What Is Next ?

- implement chain of responsability design pattern in transaction process 
- implement Logging table for transaction and it's status
- define user roles
- implement Authentication and Authorization
- unit testing
---

## 📍 End Points APIs
![image](https://github.com/user-attachments/assets/f692e70a-b812-4318-a13e-5f13cd3b70e4)
---

## 🔗 Quick Links 
- h2 databae : http://localhost:8080/h2-console
- swagger-ui : http://localhost:8080/swagger-ui/index.html

