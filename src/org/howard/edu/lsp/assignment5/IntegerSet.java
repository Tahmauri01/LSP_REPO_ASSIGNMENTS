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

    /**
     * Returns true if this set contains the given value.
     * @param value the value to look for
     * @return true if the value is in this set; false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }
 
    /**
     * Returns the largest element in this set.
     * @return the largest element
     * @throws IllegalStateException if this set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Cannot get largest element of an empty set");
        }
        return set.last();
    }

    /**
     * Returns the smallest element in this set.
     * @return the smallest element
     * @throws IllegalStateException if this set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Cannot get smallest element of an empty set");
        }
        return set.first();
    }
 
    /**
     * Adds a value to this set. If the value is already present, the set is
     * unchanged.
     * @param item the value to add
     */
    public void add(int item) {
        set.add(item);
    }
 
    /**
     * Removes a value from this set. If the value is not present, the set is unchanged.
     * @param item the value to remove
     */
    public void remove(int item) {
        set.remove(item);
    }
 
    /**
     * Returns a new set containing every element that is in this set, in {@code b}, or in both. Neither input set is modified.
     * @param b the other set
     * @return a new set representing the union
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = copy();
        result.set.addAll(b.set);
        return result;
    }
 
    /**
     * Returns a new set containing only the elements found in both this set and {@code b}. Neither input set is modified.
     * @param b the other set
     * @return a new set representing the intersection
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = copy();
        result.set.retainAll(b.set);
        return result;
    }
 
    /**
     * Returns a new set containing the elements in this set that are not in {@code b}. Neither input set is modified.
     * @param b the other set
     * @return a new set representing this set minus {@code b}
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = copy();
        result.set.removeAll(b.set);
        return result;
    }
 
    /**
     * Returns a new set containing the elements in {@code b} that are not in this set (the assignment-specific definition of complement). Neither input set is modified.
     * @param b the other set
     * @return a new set representing {@code b} minus this set
     */
    public IntegerSet complement(IntegerSet b) {
        return b.diff(this);
    }
 
    /**
     * Returns true if every element of this set is also in {@code b}. An
     * empty set is a subset of every set.
     * @param b the other set
     * @return true if this set is a subset of {@code b}; false otherwise
     */
    public boolean isSubsetOf(IntegerSet b) {
        return b.set.containsAll(set);
    }
 
    /**
     * Returns true if this set and {@code b} share no elements. An empty set
     * is disjoint from every set.
     * @param b the other set
     * @return true if the sets have no elements in common; false otherwise
     */
    public boolean isDisjoint(IntegerSet b) {
        for (Integer value : set) {
            if (b.set.contains(value)) {
                return false;
            }
        }
        return true;
    }
 
    /**
     * Returns a new set containing the elements that occur in exactly one of
     * the two sets. Neither input set is modified.
     * @param b the other set
     * @return a new set representing the symmetric difference
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        IntegerSet result = union(b);
        result.set.removeAll(intersect(b).set);
        return result;
    }
 
    /**
     * Returns true if this set contains no elements.
     * @return true if this set is empty; false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }
 
    /**
     * Returns the elements of this set in ascending order, separated by a
     * comma and one space, inside square brackets, for example
     * {@code [-3, 0, 8, 15]}. An empty set returns {@code []}.
     * @return the string form of this set
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
 
    /**
     * Returns a new IntegerSet with the same elements as this one.
     * @return an independent copy of this set
     */
    private IntegerSet copy() {
        IntegerSet result = new IntegerSet();
        result.set.addAll(set);
        return result;
    }
}