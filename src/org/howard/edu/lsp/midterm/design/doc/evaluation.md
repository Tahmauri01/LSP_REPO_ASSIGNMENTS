CourseRegistration works for one simple case, but its design breaks several of Arthur Riel's object-oriented design heuristics. The problems below make the class hard to understand, maintain, extend, and trust.

1. Public data: no encapsulation

Riel heuristic: "All data should be hidden within its class."

All five fields (studentId, studentName, email, courseCode, creditHours) are public. Any other class can read or change them at any time, with no validation. For example, nothing stops code from setting creditHours to -5 or email to null. The tuition calculation would then silently produce a negative charge, or the confirmation step would fail. Because the fields are exposed, every class that uses them depends on this exact internal representation. Renaming a field or changing its type would break all of those classes.

Affects: correctness, maintainability.

2. A god class with too many responsibilities

Riel heuristics: "A class should capture one and only one key abstraction" and "Do not create god classes/objects in your system."

The single method registerStudent() does six unrelated jobs:

calculates tuition,
applies a discount policy,
prints a confirmation to the console,
saves the record to a file,
sends a confirmation email,
logs the registration time.

It mixes business rules, user output, file storage, messaging, and logging in one place. The class has no single key abstraction; it is "the whole system" in one method. Any change to any of these jobs requires editing this class, which risks breaking the others. It also cannot be tested in parts. For example, there is no way to test the tuition calculation without also writing to a file and printing output.

Affects: maintainability, structure, testability.

3. Unrelated data kept together

Riel heuristics: "Keep related data and behavior in one place" and "Spin off non-related information into another class."

Student information (studentId, studentName, email) and course information (courseCode, creditHours) are two separate abstractions forced into one class. A student takes many courses, and a course has many students. With this design, the student's data must be copied into a new CourseRegistration object for every course, so the same student's email could be stored differently in different registrations. Student and Course should be their own classes.

Affects: structure, correctness (duplicated, inconsistent data).

4. Poor extensibility: hard-coded choices

Riel heuristic: "A class should capture one and only one key abstraction" (each changeable decision should be owned by its own class).

The class hard-codes decisions that are likely to change:

Tuition policy: 750.0 per credit hour and the 0.90 discount for 12+ hours are magic numbers inside the method. A rate change means editing and recompiling the registration code.
Storage: it always writes to "registrations.txt". Supporting a database would require rewriting the method.
Notification: it only "sends" email. Supporting text messages would add more conditionals to an already overloaded method.

Because these decisions are not separated into their own classes, the design cannot be extended without modifying, and possibly breaking, existing code.

Affects: extensibility, maintainability.

5. Unsafe error handling and resource management
catch (Exception e) { e.printStackTrace(); } catches every possible error and only prints it. If the file save fails, the method keeps going: it still prints a successful confirmation and "sends" the email. The student is told they are registered when no record was saved.
If writer.write(...) throws, writer.close() is never called, so the file handle is leaked. A try-with-resources block would close it automatically.

Affects: correctness, reliability.

6. Other weaknesses
Fake behavior: the "email" is only a System.out.println, so the method claims to do something it does not do.
Console output mixed with logic: printing directly to System.out ties the business logic to a console. It cannot be reused by a web page or mobile app.
No calculated result is kept: the tuition is a local variable that is printed and thrown away, so no other part of the system can use it.
Summary

CourseRegistration is a god class with public data that mixes several abstractions (student, course, tuition policy, storage, notification, logging) in one method. Following Riel's heuristics, the data should be hidden, and each key abstraction should become its own class with a single, clear responsibility. This is the basis for the redesign in design.md.