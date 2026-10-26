package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a book in the library system.
 * It stores its ISBN, title, author, and availability, and validates its own borrowing and returning.
 * @author Tahmauri Bobo
 */

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean available;

    /**
     * Creates a new book.
     * @param isbn   the book's ISBN
     * @param title  the book's title
     * @param author the book's author
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    /**
     * Returns the ISBN.
     * @return the ISBN of this book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Returns the title.
     * @return the title of this book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author.
     * @return the author of this book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Reports if the book is available to borrow.
     * @return true if available, false if borrowed
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Marks this book as borrowed.
     * @throws IllegalStateException if the book is already borrowed
     */
    public void borrowBook() {
        if (!available) {
            throw new IllegalStateException("Book " + isbn + " is already borrowed.");
        }
        available = false;
    }

    /**
     * Marks this book as returned/available.
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook() {
        if (available) {
            throw new IllegalStateException("Book " + isbn + " is not borrowed.");
        }
        available = true;
    }

    /**
     * Returns a description such as
     * "B101 Effective Java by Joshua Bloch [AVAILABLE]".
     * @return the formatted book details
     */
    @Override
    public String toString() {
        return isbn + " " + title + " by " + author
                + (available ? " [AVAILABLE]" : " [BORROWED]");
    }

}
