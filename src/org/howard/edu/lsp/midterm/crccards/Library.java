package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private static final int MAX_BORROWED = 3;
 
    private final Map<String, Book> books = new HashMap<>();
    private int borrowedCount = 0;

    public Library() {
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Duplicate ISBN: " + book.getIsbn());
        }
        books.put(book.getIsbn(), book);
    }

    public Book findBook(String isbn) {
        return books.get(isbn);
    }

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

    public void returnBook(String isbn) {
        Book book = requireBook(isbn);
        book.returnBook();
        borrowedCount--;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

        public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getBooksSortedByIsbn() {
        List<Book> result = new ArrayList<>(books.values());
        result.sort(Comparator.comparing(Book::getIsbn));
        return result;
    }

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
