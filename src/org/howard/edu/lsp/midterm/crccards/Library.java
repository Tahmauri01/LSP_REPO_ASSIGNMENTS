package org.howard.edu.lsp.midterm.crccards;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private static final int MAX_BORROWED = 3;
 
    private final Map<String, Book> books = new HashMap<>();
    private int borrowedCount = 0;

    public Library() {
    }

}
