# Getting Started
There are a few steps you'll need to take prior to running 
the entire application. The front-end and back-end were
developed separate from each other and are contained in individual
repositories.  

## Run the Front-end
Docker is required in order to run the front-end of the application.
Starting with the e-commerce-react-capstone-copy repository:

1. Navigate to the root folder of the repository (which contains the Dockerfile)
2. In the command prompt, create a docker image with the command:
   `docker build -t image_name .`
3. Then to run the docker image use the command 
   `docker container run -p 3000:80 image_name`


## Run the Back-end
To get the back-end up and running, 

1. An account must be made with mailtrap.io in order to run the Selenium tests for
   the reset password functionality. (If you just want the backend to work you can
   use any smtp mail server).
2. An application.yml file must be added to the src/main/resources folder 
   with the following information (some of which has been censored for security reasons)
```
server:
  port: 8080
  forward-headers-strategy: framework
springdoc:
  swagger-ui:
  path: swagger-ui-custom.html
  operationsSorter: method
spring:
  jpa:
    hibernate:
      ddl-auto: create-drop
    database-platform: org.hibernate.dialect.H2Dialect
    defer-datasource-initialization: true
  datasource:
    url: jdbc:h2:mem:memdb
    driver-class-name: org.h2.Driver
    username: sa
    password: password
  h2:
    console.enabled: true
  mail:
    host: smtp.mailtrap.io
    port: 465
    username: [mailtrap username]
    password: [mailtrap password]
jwt:
  secret: [password salt]
```
3. A testing.yml file must be added to the src/test/resources folder 
   with the following information (some of which has been censored for security reasons)
```
mailtrap:
  account-number: [account number of the mailtrap account]
  inbox-number: [inbox number of the mailtrap inbox]
  api-token: [api token of the mailtrap api]
```
4. Then to run the backend server, open the project in an IDE and run the 
   `ECommerceApplication.java` file located in `src/main/java/com/revature/ECommerceApplication.java`
5. To run the test suite, while the frontend and backend are both running,
   run the `Runner.java` file located in `src/test/java/com/revature/runners/Runner.java`
