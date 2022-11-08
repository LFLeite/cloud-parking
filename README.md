# Cloud Parking
A simple API for the control of a parking lot. Developed with the Spring Boot, Spring Security and Spring Data JPA, documented with Swagger

### Default Login
username: user

password: pass@123


## [Live version](https://parking-fl.herokuapp.com/swagger-ui/ "Cloud Parking")


## Offline DB setup using docker

### Run database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine

### Stop Database
docker stop parking-db

### Start Database
docker start parking-db
