# **ProfilePost Manager**

A full-stack Java Spring Boot application that provides secure login, profile management, and a complete Post Management System with features to create, update, view, and delete posts.
The project uses Spring Boot, Spring MVC, Thymeleaf/HTML, Spring Security, and MySQL, making it a clean example of a modern Java-backend + HTML frontend application.

🚀 Features
🔐 Authentication

User registration

Login with Spring Security

Forgot Password (Email-based reset token)

Secure session management

👤 Profile Management

View profile

Update profile

Upload profile picture

📝 Post Management

Create new posts

Update posts

Delete posts

View all posts

Sorting (Created Date / Updated Date)

Pagination (2, 5, 10, 15 items per page)

📬 Email Integration

Sends password reset emails

Configurable SMTP settings

🛠 Tech Stack

Java 17+

Spring Boot

Spring Security

Spring Data JPA (Hibernate

HTML, CSS, Bootstrap

Maven

📁 Project Structure
src/
 ├── main/
 │   ├── java/
 │   │   └── com.project.profilepostmanager/
 │   │       ├── controller/
 │   │       ├── service/
 │   │       ├── repository/
 │   │       └── model/
 │   └── resources/
 │       ├── templates/
 │       │   ├── login.html
 │       │   ├── profile.html
 │       │   ├── posts.html
 │       │   └── forgot-password.html
 │       └── application.properties

⚙️ Setup Instructions

In application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/profilepostdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

1. Configure Email
spring.mail.host=smtp.hmail.com
spring.mail.port=587
spring.mail.username=your-email
spring.mail.password=your-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
mail.transport.protocol=smtp

2. Run the project
mvn spring-boot:run

3. Access in Browser
http://localhost:8080
