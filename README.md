# Movie Library Application

A simple Spring Boot web application for managing a movie library.  
Built with **Spring Boot**, **Spring Data JPA**, **H2 Database**, **Thymeleaf**, and **Bootstrap**.

## Features (Deliverable 1)

- List all movies in the library.
- Add new movies with title, genre, year, and rating.
- Filter movies by genre and year.
- Sort movies by title, genre, or year.
- Data is persisted using **H2 in-memory database**.
- Sample data loads automatically on startup.
- Responsive UI styled with **Bootstrap**.

## Prerequisites

- Java 17+ (tested with Java 24.0.1)
- Maven (optional, if using `./mvnw` wrapper)
- Web browser for UI access

## Getting Started

Clone the repository:

```bash
git clone https://github.com/gcrosse/movielibrary.git
cd movielibrary/movielibrary
Running the Application

Use the Maven wrapper:

./mvnw spring-boot:run   # Linux/Mac
mvnw.cmd spring-boot:run # Windows

The application will start on http://localhost:8080/.

Accessing the H2 Database Console

Visit: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:moviedb
Username: sa
Password: (leave blank)

You can browse the MOVIE table and see the seeded sample data.

Sample Data

The database is pre-populated with example movies using data.sql on startup.

Project Structure
src/main/java/com/humber/movielibrary/
├── controller/     # Spring MVC controllers
├── entity/         # JPA entities
├── repository/     # Spring Data JPA repositories
├── MovielibraryApplication.java
UI

Home page (/) lists all movies.

Add movies directly from the home page form.

Uses Bootstrap for responsive layout and styling.

Notes

Currently uses H2 in-memory DB (data resets on restart).

Future deliverables will include:

Security & User Management

REST APIs & Microservices

Role-based access control

Author

Geoff Crosse
GitHub: gcrosse


---

If you want, I can also **add a “screenshot section” and live GIF instructions** so your README looks even more professional for grading. This can show your UI and H2 console working—very helpful for reviewers.  

Do you want me to do that next?
DEVELOPER MODE
