package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains a collection of books and controls the borrowing and returning of the books.
 * Books are stored in a HashMap keyed by ISBN, giving fast lookup and making
 * duplicate ISBNs easy to detect. The Library has a limit of three borrowed books at a time.
 * @author Tahmauri Bobo
 */
public class Library {
    private static final int MAX_BORROWED = 3;
 
    private final Map<String, Book> books = new HashMap<>();
    private int borrowedCount = 0;

    public Library() {
    }

    /**
     * Adds a book to the library.
     * @param book the book to add
     * @throws IllegalArgumentException if the book is null or a book with the same ISBN already exists
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Duplicate ISBN: " + book.getIsbn());
        }
        books.put(book.getIsbn(), book);
    }

    /**
     * Finds a book by ISBN.
     * @param isbn the ISBN to look up
     * @return the matching Book, or null if none exists
     */
    public Book findBook(String isbn) {
        return books.get(isbn);
    }

    /**
     * Borrows the book with the given ISBN.
     * @param isbn the ISBN of the book to borrow
     * @throws IllegalArgumentException if no book has that ISBN
     * @throws IllegalStateException if the book is already borrowed or three books are already borrowed
     */
    public void borrowBook(String isbn) {
        Book book = requireBook(isbn);
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book " + isbn + " is already borrowed.");
        }
        if (borrowedCount >= MAX_BORROWED) {
            throw new IllegalStateException("Borrowing limit of " + MAX_BORROWED + " reached.");
        }
        book.borrowBook();
        borrowedCount++;
    }

    /**
     * Returns the book with the given ISBN.
     * @param isbn the ISBN of the book to return
     * @throws IllegalArgumentException if no book has that ISBN
     * @throws IllegalStateException if the book is not currently borrowed
     */
    public void returnBook(String isbn) {
        Book book = requireBook(isbn);
        book.returnBook();
        borrowedCount--;
    }

    /**
     * Returns all books that are currently available.
     * @return a list of available books
     */
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Returns all books whose author exactly matches (case-sensitive), including borrowed books.
     * @param author the author to match
     * @return a list of matching books (empty if none)
     */
        public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Returns all books sorted by ISBN in ascending order, without changing the library.
     * @return a new sorted list of all books
     */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> result = new ArrayList<>(books.values());
        result.sort(Comparator.comparing(Book::getIsbn));
        return result;
    }

    /**
     * Returns the number of books currently borrowed.
     * @return the borrowed book count
     */
    public int getBorrowedBookCount() {
        return borrowedCount;
    }
 
    private Book requireBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("No book with ISBN " + isbn);
        }
        return book;
    }

}
