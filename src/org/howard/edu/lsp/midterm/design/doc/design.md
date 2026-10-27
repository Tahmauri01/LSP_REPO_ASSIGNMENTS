Class: Student 
Responsibilities:
Store student ID, name, and email (private fields)
Provide student information through getters

------

Class: Course 
Responsibilities:
Store course code and credit hours (private fields)
Provide course information through getters

------

Class: TuitionCalculator 
Responsibilities:
Know the per-credit-hour rate ($750)
Know the heavy-load discount rule (10% off at 12+ credit hours)
Calculate tuition for a given number of credit hours
Collaborators: Course

------

Class: Registration 
Responsibilities:
Represent one student enrolled in one course
Store the student, course, calculated tuition, and registration time
Provide registration details
Collaborators: Student, Course

------

Class: RegistrationService 
Responsibilities:
Coordinate the registration process: create the Registration, request the tuition, save the record, send the confirmation, and log the event
Contain no storage, messaging, or pricing details itself
Collaborators: Student, Course, Registration, TuitionCalculator, RegistrationRepository, ConfirmationSender, RegistrationLogger

------

Class: RegistrationRepository 
Responsibilities:
Save registration records
Handle and report storage errors instead of hiding them
Collaborators: Registration

------

Class: ConfirmationSender 
Responsibilities:
Send a registration confirmation to the student
Collaborators: Registration, Student

------

Class: RegistrationLogger 
Responsibilities:
Record when a registration was processed
Collaborators: Registration