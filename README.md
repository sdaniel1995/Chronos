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

   - Login using your registered email and password.
   - If you do not have an account create on be clicking the create account link.
   - If you are an Employee sign into your account and create a new timesheet submission or update any profile information.
   - A user can update information on their profile by clicking the more button underneath their profile image and choosing 'Edit Profile'.
   - If you are an Admin/Manager sign into your account and choose which time sheet submission you would like to decline or approve (if there are any) by entering        the relative Employee id that is displayed.
   - Finally logout by clicking the more button underneath your profile picture and choosing log out.
