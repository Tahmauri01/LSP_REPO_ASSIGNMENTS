Accommodating the new requirements

The Part 2 design already isolates storage in RegistrationRepository and confirmation messaging in ConfirmationSender. Supporting the new requirements therefore means changing only those two areas. RegistrationService, Registration, Student, Course, and TuitionCalculator do not change.

Storage (file or database): RegistrationRepository becomes an abstraction (an interface) with two implementations:

FileRegistrationRepository writes records to a local file.
DatabaseRegistrationRepository writes records to a database.

Confirmations (email or text): ConfirmationSender becomes an abstraction with two implementations:

EmailConfirmationSender sends an email to the student's email address.
TextConfirmationSender sends a text message to the student's phone number.

RegistrationService keeps working only with the RegistrationRepository and ConfirmationSender abstractions. It never knows which concrete version it is using. The concrete versions are chosen when the system is set up for its deployment environment and then passed to RegistrationService.

Changes to the CRC cards
RegistrationRepository: now an abstraction. Responsibility: "define how registration records are saved." Collaborators: Registration.
New cards FileRegistrationRepository and DatabaseRegistrationRepository: Responsibility: "save registration records to a file / to a database." Collaborators: Registration.
ConfirmationSender: now an abstraction. Responsibility: "define how confirmations are sent." Collaborators: Registration, Student.
New cards EmailConfirmationSender and TextConfirmationSender: Responsibility: "send a confirmation by email / by text message." Collaborators: Registration, Student.
Student: add the responsibility "store phone number" so that text confirmations have a destination.
RegistrationService: responsibilities are unchanged. Its collaborators still name the two abstractions, not the concrete classes.
Key decision: who owns saving a registration?

I gave the responsibility for saving a registration to RegistrationRepository, not to Registration itself or to RegistrationService.

If Registration saved itself, it would need to know about files and databases, mixing data with storage details. That violates Riel's heuristic that a class should capture one key abstraction. Adding database support would also mean editing Registration. If RegistrationService did the saving, it would become a smaller version of the original god class, doing coordination plus storage.

Because storage lives in its own class, swapping a file for a database is a matter of supplying a different RegistrationRepository implementation. No other class changes. This is the same reason the design can absorb the email-or-text requirement: each changeable detail is owned by exactly one class behind a stable abstraction.