package org.howard.edu.lsp.assignment5;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Creates a set of integers, stored in ascending order.
 */
public class IntegerSet {

    /**
     * Initializes set
     */
    private final TreeSet<Integer> set = new TreeSet<Integer>();
    
    /**
     * Creates empty set
     */
    public IntegerSet() {
    }

    /**
     * Removes all elements from this set.
     */
    public void clear() {
        set.clear();
    }
 
    /**
     * Returns the number of elements in this set.
     * @return the number of elements in this set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if this set and the given set contain exactly the same elements, regardless of insertion order.
     * @param b the set to compare with
     * @return true if both sets contain the same elements; false otherwise,
     *         including when {@code b} is null
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        return set.equals(b.set);
    }
}