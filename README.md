
## Sign in  with Bootstrap and JDBC Servlet




![image (1)](https://github.com/user-attachments/assets/2230ce18-cab9-4518-83d4-f2f4b1ff5fbd)


## Overview
This project implements a stylish sign in system using Bootstrap for the frontend and JDBC Servlet for backend integration with SQL database. It features a modern sign in  form with social login options and a signup feature that remembers user information.




## Features

* Responsive Sign in  form using Bootstrap

* Email and password authentication
* "Remember me" functionality
* Social login options (Facebook, Twitter, Google)
* User registration ("Create an account")
* Backend integration using JDBC Servlet
* SQL database for storing user information
## Technologies Used

#### Frontend:

* HTML5
* CSS3
* Bootstrap 5
* JavaScript


#### Backend:

* Java Servlets
* JDBC (Java Database Connectivity)


#### Database:

* MySQL
## Setup and Installation

1. Clone the repository:

git clone https://github.com/kirat13/SignUp-Form-Java-JDBC-Servlet-

2. Set up MySQL database and create a users table (schema provided below).
3. Update DatabaseUtil.java with your database credentials.
4. Build the project using Maven:

mvn clean install

5. Deploy the generated WAR file to a servlet container like Tomcat.



## Database Schema

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,

    email VARCHAR(255) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

);


![image (1)](https://github.com/user-attachments/assets/dbc1d767-a59d-4ce9-bf3d-39df3ca2911c)

## Usage

Access the login page: http://localhost:8002/SignUp/login.jsp

Use the "Create an account" link to register a new user.

Log in using your email and password.

Check "Remember me" to stay logged in.


## JDBC Servlet Implementation

The LoginServlet and SignUpServlet handle user authentication and registration respectively. 

They use UserDAO to interact with the database through JDBC.


## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
## License
This project is open source and available under the MIT License.
