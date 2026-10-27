1. AI Tool: Claude (Anthropic), accessed through claude.ai
Date used: October 26, 2026
What I asked for: I uploaded the midterm instructions and asked for help completing the project. For Question 1, Claude:
wrote Book.java and Library.java with Javadoc comments,
explained the choice of a HashMap<String, Book> keyed by ISBN (fast lookup and easy duplicate detection),
explained why Library.borrowBook() checks availability and the three-book limit before changing any state, so failed operations do not change the collection, the count, or book availability,
provided the text of the instructor Driver.java exactly as given in the exam,
drafted the explanation in crccards.md.
How it helped: It gave me a working implementation and explained the design decisions so I could understand and check them.
How I verified the work: I compiled the classes with the unmodified instructor Driver.java and ran it. The result was:
  RESULT: 44 PASSED, 0 FAILED
  FUNCTIONAL SCORE: 25.00 / 25

I also reviewed the code against each business rule in the exam (duplicate ISBNs, the three-book limit, case-sensitive author search, sorted ISBN retrieval, exception types).

Complete AI Conversation Transcript:

all files have been created walk me through this project

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

Question 1 has five files, three Java and two Markdown:

crccards/
├── Book.java
├── Library.java
├── Driver.java
└── doc/
    ├── crccards.md
    └── development_log.md

Book.java: one book

Data: isbn, title and author, which never change after creation, plus available. All four are private, so other classes can’t flip available directly, as the rules require.
Constructor: sets the three values and starts the book as available.
Getters: getIsbn(), getTitle(), getAuthor(), isAvailable().
borrowBook(): if the book is already borrowed, it throws IllegalStateException. Otherwise it marks the book unavailable.
returnBook(): the opposite. If the book is already available, it throws. Otherwise it marks it available.
toString(): builds text like B101 Effective Java by Joshua Bloch [AVAILABLE], or [BORROWED] when it’s out.
Its CRC card: it manages only its own state and knows nothing about Library, so it has no collaborators.

Library.java: the collection of books

Storage: a HashMap<String, Book> keyed by ISBN. This is your “appropriate collection” choice. Finding a book by ISBN is instant, and containsKey() catches duplicates.
borrowedCount: tracks how many books are out, and MAX_BORROWED = 3 sets the limit.
addBook(): throws IllegalArgumentException if a book with that ISBN is already there, so the original isn’t replaced.
findBook(): returns the book, or null if it’s not found.
borrowBook(): finds the book (throws IllegalArgumentException if the ISBN is missing), checks it’s available, then checks the limit. Only after every check passes does it call book.borrowBook() and add 1 to the count. That way a failed borrow changes nothing.
returnBook(): finds the book, calls book.returnBook() (which throws if the book wasn’t borrowed), then subtracts 1 from the count.
getAvailableBooks(): loops through the books and keeps only the available ones.
getBooksByAuthor(): keeps books whose author matches exactly, using equals, which is case-sensitive. Borrowed books are included.
getBooksSortedByIsbn(): copies the books into a new list and sorts that copy by ISBN, so the library itself never changes.
requireBook(): a private helper. It’s the shared “find it or throw” step that both borrow and return use.

Driver.java: the instructor’s test program

You don’t write or change it. It creates books, runs 44 checks on every rule, prints PASS or FAIL for each, and calculates your score out of 25. Yours should end with 44 PASSED, 0 FAILED.

doc/crccards.md: the design explanation (4 pts)

Why the arrow points one way: Library collaborates with Book, but Book doesn’t collaborate with Library, because Library’s responsibilities need Book and Book’s don’t need Library.
Why Library enforces the limit: the 3-book limit is a rule about the whole collection, and only Library can see all the books.

doc/development_log.md: the disclosure (3 pts)

Lists the AI and other resources you used, how they helped, and how you checked the work. It must also include the full transcript of this chat, which you paste in.

How they fit together: Driver calls Library and Book, and Library calls Book. Book calls nothing else, which is the same structure the CRC cards describe.

walk me through boo and library classes

This goes through the actual code from top to bottom, with what each part does and why.

Book.java

Package and class

java
package org.howard.edu.lsp.midterm.crccards;
public class Book {

The package line must match the folder path, or the code won’t compile in that folder.

Fields

java
private final String isbn;
private final String title;
private final String author;
private boolean available;
private means no other class can touch these directly. That’s how you meet the rule “availability cannot be modified directly by other classes.”
final means isbn, title and author are set once and never change.
available isn’t final because it flips back and forth between true and false.

Constructor

java
public Book(String isbn, String title, String author) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.available = true;
}

this.isbn is the field and isbn is the parameter, so this. tells them apart. The last line meets the rule “new books start available.”

Getters

java
public String getIsbn() { return isbn; }
public boolean isAvailable() { return available; }

Other classes can read the values but can’t change them. getTitle() and getAuthor() work the same way. Boolean getters are usually named isX rather than getX.

borrowBook()

java
public void borrowBook() {
    if (!available) {
        throw new IllegalStateException("Book " + isbn + " is already borrowed.");
    }
    available = false;
}

The guard comes first: if the book is already out, it throws and stops. Only a valid borrow gets to available = false. IllegalStateException is the right type because the request is fine but the object is in the wrong state for it.

returnBook()

java
public void returnBook() {
    if (available) {
        throw new IllegalStateException("Book " + isbn + " is not borrowed.");
    }
    available = true;
}

It mirrors borrowBook(): you can’t return a book that’s already on the shelf.

toString()

java
@Override
public String toString() {
    return isbn + " " + title + " by " + author
            + (available ? " [AVAILABLE]" : " [BORROWED]");
}
@Override means this replaces the default toString() every Java object inherits.
condition ? a : b is a one-line if/else.
The output has to match exactly, spaces included, because the Driver compares the strings: B101 Effective Java by Joshua Bloch [AVAILABLE].
Library.java

Imports

java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

These bring in the Collections Framework classes the Library uses.

Fields

java
private static final int MAX_BORROWED = 3;
private final Map<String, Book> books = new HashMap<>();
private int borrowedCount = 0;
MAX_BORROWED is a named constant instead of a “magic number” 3 scattered in the code. static means it’s shared by the class and final means it never changes.
Map<String, Book> stores ISBN → Book pairs. This is your “appropriate collection.” Why a HashMap and not an ArrayList:
books.get(isbn) finds a book instantly instead of looping through a list.
books.containsKey(isbn) checks for duplicates in one line.
borrowedCount is a running total of books that are out.

addBook()

java
public void addBook(Book book) {
    if (book == null) throw new IllegalArgumentException(...);
    if (books.containsKey(book.getIsbn())) {
        throw new IllegalArgumentException("Duplicate ISBN: " + book.getIsbn());
    }
    books.put(book.getIsbn(), book);
}

The check runs before put. That matters because put with an existing key would overwrite the original book, which the rules forbid. IllegalArgumentException fits because the input itself is bad.

findBook()

java
public Book findBook(String isbn) {
    return books.get(isbn);
}

HashMap.get already returns null for a missing key, which is exactly what the spec asks for. It returns the same object, which the Driver checks with ==.

borrowBook(): the most important method

java
public void borrowBook(String isbn) {
    Book book = requireBook(isbn);              // 1. must exist
    if (!book.isAvailable()) {                  // 2. must be on the shelf
        throw new IllegalStateException(...);
    }
    if (borrowedCount >= MAX_BORROWED) {        // 3. under the limit
        throw new IllegalStateException(...);
    }
    book.borrowBook();                          // 4. delegate the state change
    borrowedCount++;                            // 5. update the count
}
All checks before any change. If something fails partway, nothing has changed yet. That’s the rule “failed operations must not change the collection, count, or availability.”
Availability before the limit. With three books out, borrowing an already-borrowed book should say “already borrowed,” not “limit reached.”
Step 4 delegates. Library doesn’t set available itself; it asks Book to. That’s the rule “locate the Book and delegate its state change.”

returnBook()

java
public void returnBook(String isbn) {
    Book book = requireBook(isbn);
    book.returnBook();      // throws if the book isn't borrowed
    borrowedCount--;
}

The validation is left to Book.returnBook(). If it throws, borrowedCount-- never runs, so the count stays correct.

getAvailableBooks() and getBooksByAuthor()

java
List<Book> result = new ArrayList<>();
for (Book book : books.values()) {
    if (book.isAvailable()) result.add(book);
}
return result;
books.values() gives all the Book objects in the map.
These methods always return a new list, never null, so “no matches” is an empty list as required.
The author version uses book.getAuthor().equals(author). equals is case-sensitive, so “robert martin” doesn’t match “Robert Martin.” Borrowed books aren’t filtered out, so they’re included.

getBooksSortedByIsbn()

java
List<Book> result = new ArrayList<>(books.values());
result.sort(Comparator.comparing(Book::getIsbn));
return result;
It copies the books into a new list first, so sorting can’t affect the Library.
Comparator.comparing(Book::getIsbn) means “order the books by their ISBN.” Strings sort alphabetically, which is the lexicographical order the exam asks for.
An empty library gives an empty list automatically.

getBorrowedBookCount()

java
public int getBorrowedBookCount() { return borrowedCount; }

requireBook(): private helper

java
private Book requireBook(String isbn) {
    Book book = books.get(isbn);
    if (book == null) throw new IllegalArgumentException("No book with ISBN " + isbn);
    return book;
}

Both borrow and return need “find it or throw,” so it’s written once. It’s private because it’s an internal tool, not part of the public interface, so it doesn’t need Javadoc.

One way to remember the whole thing
Book guards its own state: “I can’t be borrowed twice.”
Library guards rules about the whole collection: “this ISBN exists,” “no duplicates,” “no more than 3 out.” Then it hands the state change to Book.

That split is exactly what you explain in crccards.md.