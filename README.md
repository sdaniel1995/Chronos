# Project 1 - Chronos
Chronos is an Online transaction processing (OLTP) application to manage the processing of requests and responses from a client HTML/JS application to a Java backend server, then a Postgresql database. It is full stack web application for managing and keeping track of an employee's timesheets.

### Tools & APIs
- [x] Agile User Stories
- [x] Java SE 8
- [x] Gradle
- [x] JDBC
- [x] PostgreSQL
- [x] JavaEE Servlet
- [x] HTML/JS/CSS
- [x] AJAX/Fetch
- [x] JUnit
- [x] log4j
- [x] Optional:
    - [x] Bootstrap

### Architecture
- [x] Anemic/DDD OR n-tier package & class structure
- [x] Design Patterns:
    - [x] Dependency Injection
    - [x] Data Access Object
    - [x] Model-View-Controller
- [x] SQL Normalization (3rd form)

### Functionality
- [x] CRUD - Create, Read, Update, Delete
- [x] Web App dashboard interface
- [x] Asynchronous interface updates
- [x] Login - Authentication & Authorization
- [x] Database persistance
- [x] Session management

### Presentation
- [x] Prepare a demonstration of functionality requirements through a browser
- [x] Prepare visual aides (slides) introducing the project requirements and features

### User stories
- An Employee...
    - [x] can login
    - [x] can view the Employee Homepage
    - [x] can logout
    - [x] can submit a new timesheet
    - [x] can upload an image to their profile
    - [x] can view their status of their submitted timesheets
    - [x] can view their information
    - [x] can update their information

- A Manager...
    - [x] can login
    - [x] can view the Manager Homepage
    - [x] can logout
    - [x] can approve/deny pending timesheet submissions
    - [x] can view all timesheets from all employees
    - [x] can view their information
    - [x] can update their information
    - [x] can upload an image to their profile

### Instructions for Use

    - Login using your registered email and registered.
Initial user and workout data is loaded internally from csv file
Depending on user or admin credentials you will be routed to the appropriate landing page
For admin you will have access to:
Can view all user’s workouts
Can view all users and passwords
Can add a user -Can delete a workout
For User you ill have access to:
View his/her individual workouts
Delete a workout
Add a workout -Search for another athlete to run with
