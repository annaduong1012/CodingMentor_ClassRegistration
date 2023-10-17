# CodingMentor_ClassRegistration

## Technologies: 
- Java

## Introduction:
This is a course registration system developed in Java. It allows users to register new accounts, log in, view course details, and register courses.

## Usage:
- The first screen shows the login menu, in which you can choose to register a new account or log in.

### Register:
- Once registered, user details will be stored in the Database.USERS_DB.
- The same userID cannot be registered twice

### Login:
- UserID and password have to match with Database.USERS_DB
- If the userID is correct but the wrong password --> failed login, the account will be locked after 3 attempts.

### Course Menu:
- Once logged in, the user will be shown the course menu.
- User can select a course to view more details, register course or view mentor details.
- The same course cannot be registered more than once.
- There is an option to view all your registered courses.

## To be developed:
- In the Course Menu option, if keying anything other than a number, the program will break --> need to catch the error
- Add function to delete course
- Add an option for the user to choose to return to the main menu if required, currently, it's auto-loop.
- How to unlock account once locked?

