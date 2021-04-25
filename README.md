# Project 1 - Chronos
A web application for managing and keeping track of employee attendance and tasks.

### Tools & APIs
- [] Agile User Stories
- [x] Java SE 8
- [x] Gradle
- [x] JDBC
- [x] PostgreSQL
- [x] JavaEE Servlet
- [x] HTML/JS/CSS
- [x] AJAX/Fetch
- [] JUnit
- [] log4j
- [] Jest
- [] Optional:
    - [] Docker, Docker-Compose
    - [] React
    - [x] Bootstrap
    - [] Remote hosting (AWS EC2/RDS)
    - [] Jenkins CI automation
    - [] Mockito

### Architecture
- [x] Anemic/DDD OR n-tier package & class structure
- [] Design Patterns:
    - [x] Dependency Injection
    - [x] Data Access Object
    - [] Business Delegate
    - [x] Model-View-Controller
    - [] Front Controller
- [x] SQL Normalization (3rd form)
- [] PL/pgSQL

### Functionality
- [x] CRUD - Create, Read, Update, Delete
- [x] Web App dashboard interface
- [x] Asynchronous interface updates
- [x] Login - Authentication & Authorization
- [x] Database persistance
- [x] Session management

### Presentation
- [] Prepare a demonstration of functionality requirements through a browser
- [] Prepare visual aides (slides) introducing the project requirements and features

### User stories
- An Employee...
    - [x] can login
    - [x] can view the Employee Homepage
    - [x] can logout
    - [] can submit a reimbursement request
    - [] can upload an image of his/her receipt as part of the reimbursement request
    - [] can view their pending reimbursement requests
    - [] can view their resolved reimbursement requests
    - [] can view their information
    - [] can update their information
    - [] receives an email when one of their reimbursement requests is resolved (optional)

- A Manager...
    - [x] can login
    - [x] can view the Manager Homepage
    - [x] can logout
    - [] can approve/deny pending reimbursement requests
    - [] can view all pending requests from all employees
    - [] can view images of the receipts from reimbursement requests
    - [] can view all resolved requests from all employees and see which manager resolved it
    - [] can view all Employees
    - [] can view reimbursement requests from a single Employee 
