# Employee-Reimbursement-System (ERS)
## Project Description
The ERS manages requests for reimbusement for work related expenses. Employees can submit requests, view thier past requests, and view thier personal information. Managers can view all requests, open requests, closed requests, employee information, and the requests of an individual employee. Both employees and managers can login and logout.
## Technologies Used
* JUnit - version 4.11
* Hibernate - version 4.3.11
* PostgreSQL - version 42.2.23
* Javalin - version 4.0.0
* Log4j - version 2.14.1
* Maven - version 4.0.0
## Features
### Employee
* Can login/logout
* Can view thier pending requests
* Can view thier resolved requests
* Can view thier information
* Can submit a new request
### Manager
* Can login/logout
* Can view pending requests from all employees
* Can view resolved requests from all employees
* Can view all employee information
* Can view requests from a single employee
### TODO
* Allow managers to approve/deny pending requests
## Getting Started
* The project uses an AWS RDS with a PostgreSQL database
### Clone Repository
* Copy the HTTP link
![Clone](https://user-images.githubusercontent.com/56489056/138535287-f2429038-9973-4f9a-9cec-36b593c31b6c.png)
* For Windows, open your commend line interface
* `cd` into your intended local repo
* `git clone <link>`
* For Unix, open git bash
* Change working directory to your intended local repo
* `git clone <link>`
### Open in IDE
![IDE](https://user-images.githubusercontent.com/56489056/138535609-2a29ac2d-fa2d-4330-9649-8c515d33a56a.png)
### Ensure Frameworks are Configured
![Frame](https://user-images.githubusercontent.com/56489056/138535766-71db98ca-64f5-42e5-ad36-dfa6b7eaab17.png)
![FrameConf](https://user-images.githubusercontent.com/56489056/138535778-4aff38c4-35dd-4446-b1de-39b13275e3dd.png)
* You can now run the project
* Navigate to localhost:7000 in browser
## Usage
### Login
* You may login as an employee or manager
![Login](https://user-images.githubusercontent.com/56489056/138535901-d1142d69-3cbc-45b2-86e3-8e9be3f90e83.png)
### Employee Homepage
* This page contains buttons and form for the use of employee features
![Emp](https://user-images.githubusercontent.com/56489056/138535928-6a676433-0fd7-49b7-a7de-02362d29c0c8.png)
### Manager Homepage
* This page contains buttons and form for the use of various manager features
![Mana](https://user-images.githubusercontent.com/56489056/138535977-5e92e5cb-5b23-4157-ba4d-5c8ed58d2c21.png)
## License
This project uses the following license: GNU GPLv3








