Resources Used
1. AI Tool: Claude (Anthropic), accessed through claude.ai
Date used: October 26, 2026
What I asked for: I uploaded the midterm instructions and asked for help completing the project. For Question 3, Claude:
worked out from the provided Driver.java which classes were needed (Employee, FullTimeEmployee, PartTimeEmployee, Contractor) and that each subclass needs a (hoursWorked, hourlyRate) constructor,
wrote the abstract Employee base class with an abstract calculatePay() method,
wrote the three subclasses, each overriding calculatePay() with its own pay rule (full-time overtime at 1.5x beyond 40 hours, part-time straight pay, contractor 15% premium),
added Javadoc comments for all classes, public constructors, and public methods,
explained why the refactor replaces the original if statements with polymorphism, and where each file goes in the package.
How it helped: It showed me how to turn the type-checking conditionals in EmployeePayCalculator into an inheritance hierarchy, where each class owns its own pay rule and the Driver calls calculatePay() through an Employee reference.
How I verified the work: I compiled the classes with the unmodified instructor Driver.java and ran it. The result was:
  RESULT: 12 PASSED, 0 FAILED

I also checked the overtime math by hand: 45 hours at $20 = (40 x 20) + (5 x 20 x 1.5) = 800 + 150 = 950, which matches the Driver's expected value.

Complete AI Conversation Transcript

all files have been created walk me through this project

Shared 6 files, ran 3 commands
I tested the code for Questions 1 and 3 against your instructor’s Drivers. Question 1 passes all 44 checks (25/25) and Question 3 passes all 12. Here’s how to finish each part.

Question 1: Library (35 pts)
Paste Book.java and Library.java into your crccards folder. Copy the Driver from the exam into Driver.java without changing it. Replace “Your Name” in each @author tag.
Run the Driver yourself and confirm you get RESULT: 44 PASSED, 0 FAILED.
Things you should be able to explain:
Why a HashMap keyed by ISBN: looking up a book is fast, and it’s easy to spot a duplicate ISBN.
Order of checks in borrowBook: the Library checks everything before changing anything, so a failed borrow leaves the count and the book’s state alone. “Already borrowed” is checked before the 3-book limit, and both throw IllegalStateException.
Who changes a book’s state: the Library finds the book, then calls book.borrowBook() or book.returnBook() itself, which satisfies the delegation rule.
crccards.md (3–5 sentences): cover two points.
Library’s card lists Book as a collaborator because it needs Book to coordinate borrowing. Book’s card lists no collaborators because it only manages its own data and availability. That makes the dependency one-way and keeps Book reusable.
The 3-book limit counts across the whole collection. A single Book can’t see how many other books are out, so the rule belongs to Library, whose card says “enforce borrowing limit.”
Question 3: Inheritance (30 pts)
Put Employee.java, FullTimeEmployee.java, PartTimeEmployee.java and Contractor.java in the inheritance folder, plus the unmodified Driver. Update the @author tags.
The design to describe: Employee is an abstract class with one abstract method, calculatePay(). Each subclass overrides it with its own pay rule. The Driver calls employee.calculatePay() on an Employee reference, and that’s the polymorphism. No if/else or design pattern is needed.
Checking the full-time overtime math by hand: 45 hours × $20 = (40 × 20) + (5 × 20 × 1.5) = 800 + 150 = 950. That matches the Driver.
Question 2: Design evaluation (25 pts)
These files are your writing, so here’s what each one needs to cover.

evaluation.md: the problems in CourseRegistration:
All its fields are public, which breaks Riel’s heuristic that all data should be hidden inside its class.
One method does six jobs: calculating tuition, applying the discount, printing, saving to a file, emailing and logging. That breaks “a class should capture one key abstraction” and makes it a “god class.”
Student data and course data are mixed into one class, which is poor cohesion.
The numbers 750 and 0.90 are hard-coded.
catch (Exception e) hides failures, and the FileWriter isn’t closed if an error happens.
Changing the storage or notification method means editing this one class, which hurts maintainability and extensibility.
design.md: CRC cards in the required “Class: / Responsibilities: / Collaborators:” format. Good candidates:
Student (id, name, email)
Course (code, credit hours)
TuitionCalculator (rate, discount rule)
Registration (links a Student to a Course and holds the tuition)
RegistrationService (coordinates the steps)
RegistrationRepository (saves records)
NotificationService (sends confirmations)
RegistrationLogger
design_rationale.md:
Turn RegistrationRepository into an abstraction with two versions, FileRegistrationRepository and DatabaseRegistrationRepository. Do the same for NotificationService: EmailNotificationService and TextNotificationService.
RegistrationService works only with the abstractions, so the deployment environment decides which version gets used.
For the “one important decision”: argue that saving belongs to the repository, not to Registration. A registration shouldn’t need to know how it’s stored, and that’s what lets you swap file for database without touching it.
Development logs (5 pts each, and they matter)
development_log.md, development_log_q2.md and development_log_q3.md must each include the complete transcript of this conversation: your prompts and my replies. You can also use a working share link to the chat. In each log, say what you used from it (the Java code for Q1 and Q3, the design outline for Q2) and that you checked it by running the Drivers. If you use any other websites or lecture notes, list them too, with full URLs.

Question 4: Reflection (10 pts)
I can’t help with this one. The exam says no AI for any part of it, including editing or reviewing. Write it yourself, and don’t paste it into this chat or any other AI tool. Make sure you answer all three prompts (benefits, challenges, moving forward), each with a specific example from your own semester.

Before you push: check the folder structure against the tree in the exam. Every .java file’s package line must match its folder. Don’t commit .class files or IDE files, and push early.

Book
Code
·JAVA
Library
Code
·JAVA
Employee
Code
·JAVA
Fulltimeemployee
Code
·JAVA
Parttimeemployee
Code
·JAVA
Contractor
Code
·JAVA
are comments a requirements

Yes, but only Javadoc comments, and they’re worth points:

Question 1 (3 points): every class needs a Javadoc description with an @author tag. Every public method needs a description plus @param, @return and @throws tags where they apply.
Question 3 (2 points): every class, public constructor and public method needs Javadoc.
Regular inline // comments aren’t required anywhere.

The files I gave you already have all the required Javadoc. The only thing you need to change is “Your Name” in each @author tag.

where does employee go

Employee.java goes in the inheritance folder, next to the Q3 Driver and the other three employee classes:

org/howard/edu/lsp/midterm/inheritance/
├── Driver.java
├── Employee.java
├── FullTimeEmployee.java
├── PartTimeEmployee.java
├── Contractor.java
└── doc/
    └── development_log_q3.md
Those four employee files are what the exam’s tree calls “[Your implementation .java files]”. Each one starts with package org.howard.edu.lsp.midterm.inheritance;, which matches that folder.

Shared a file, ran a command
I’ve written development_log_q3.md, which goes in inheritance/doc/. It covers what I helped with on Question 3: working out the classes from the Driver, writing Employee and the three subclasses, and adding the Javadoc. It also records how you checked the work, with the 12/12 Driver result and the 45-hour overtime math done by hand.

Before you submit, finish the same two parts as the Question 1 log:

Paste the full transcript of this chat at the bottom, with every prompt and every full response. The rubric is worth 5 points here, so don’t summarize.
Fill in “Other resources.” List your notes, textbook or website URLs, or write “No other resources were used.”
Development log q3
Document
·MD


