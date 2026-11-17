package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Assignment 6: JUnit 5 tests for IntegerSet.
 *
 * Complete every TODO. Do not remove, rename, or disable test methods.
 * Each test must contain meaningful assertions and run independently.
 */
public class IntegerSetTest {
    /**
     * Helper: builds a new, independent IntegerSet containing the given values.
     * Every test creates its own sets, so no state is shared between tests.
     */
    private static IntegerSet setOf(int... values) {
        IntegerSet s = new IntegerSet();
        for (int v : values) {
            s.add(v);
        }
        return s;
    }
 
    // ===== clear() =====
 
    /**
     * Create a populated set; call clear(); assert that it is empty and its length is zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsPopulatedSet() {
        // Arrange
        IntegerSet s = setOf(1, 2, 3);
        assertEquals(3, s.length());
        // Act
        s.clear();
        // Assert
        assertTrue(s.isEmpty());
        assertEquals(0, s.length());
        assertFalse(s.contains(1));
        assertFalse(s.contains(2));
        assertFalse(s.contains(3));
        assertEquals("[]", s.toString());
    }
 
    /**
     * Clear an already empty set; verify it remains empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsEmptySet() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act
        s.clear();
        // Assert
        assertTrue(s.isEmpty());
        assertEquals(0, s.length());
        assertEquals("[]", s.toString());
    }
 
    // ===== length() =====
 
    /**
     * Add repeated and unique integers; assert the number of distinct elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthCountsUniqueElements() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act
        s.add(5);
        s.add(5);
        s.add(-2);
        s.add(7);
        s.add(-2);
        s.add(0);
        // Assert
        assertEquals(4, s.length());
    }
 
    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act
        int len = s.length();
        // Assert
        assertEquals(0, len);
    }
 
    // ===== equals() =====
 
    /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsIgnoresInsertionOrder() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3, 4);
        IntegerSet b = setOf(4, 2, 3, 1);
        // Act
        boolean ab = a.equals(b);
        boolean ba = b.equals(a);
        // Assert
        assertTrue(ab);
        assertTrue(ba);
    }
 
    /**
     * Construct sets of equal length with different elements; assert inequality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsDetectsDifferentContents() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet b = setOf(1, 2, 4);
        assertEquals(a.length(), b.length());
        // Act
        boolean ab = a.equals(b);
        boolean ba = b.equals(a);
        // Assert
        assertFalse(ab);
        assertFalse(ba);
    }
 
    /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsEmptySetsEqual() {
        // Arrange
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        assertNotSame(a, b);
        // Act and Assert
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }
 
    /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsSameObjectAndDifferentSizes() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet bigger = setOf(1, 2, 3, 4);
        // Act and Assert
        assertTrue(a.equals(a));
        assertFalse(a.equals(bigger));
        assertFalse(bigger.equals(a));
    }
 
    // ===== contains() =====
 
    /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsPresentAndAbsent() {
        // Arrange
        IntegerSet s = setOf(-4, 10, 25);
        // Act and Assert
        assertTrue(s.contains(10));
        assertTrue(s.contains(-4));
        assertFalse(s.contains(11));
        assertFalse(s.contains(4));
    }
 
    /**
     * Verify an empty set does not contain an arbitrary integer.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsEmptySetContainsNothing() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act and Assert
        assertFalse(s.contains(0));
        assertFalse(s.contains(42));
        assertFalse(s.contains(-1));
    }
 
    // ===== largest() =====
 
    /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet mixed = setOf(-10, 0, 37, 5, -3);
        IntegerSet allNegative = setOf(-8, -2, -15);
        // Act
        int mixedMax = mixed.largest();
        int negMax = allNegative.largest();
        // Assert
        assertEquals(37, mixedMax);
        assertEquals(-2, negMax);
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act and Assert
        assertThrows(IllegalStateException.class, () -> s.largest());
    }
 
    // ===== smallest() =====
 
    /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet mixed = setOf(12, 0, -7, 3, -1);
        IntegerSet allPositive = setOf(9, 4, 20);
        // Act
        int mixedMin = mixed.smallest();
        int posMin = allPositive.smallest();
        // Assert
        assertEquals(-7, mixedMin);
        assertEquals(4, posMin);
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act and Assert
        assertThrows(IllegalStateException.class, () -> s.smallest());
    }
 
    // ===== add() =====
 
    /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act
        s.add(7);
        s.add(7);
        s.add(7);
        // Assert
        assertEquals(1, s.length());
        assertTrue(s.contains(7));
        assertEquals("[7]", s.toString());
    }
 
    /**
     * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        // Arrange
        IntegerSet s = new IntegerSet();
        // Act
        s.add(Integer.MAX_VALUE);
        s.add(0);
        s.add(Integer.MIN_VALUE);
        // Assert
        assertEquals(3, s.length());
        assertTrue(s.contains(Integer.MIN_VALUE));
        assertTrue(s.contains(0));
        assertTrue(s.contains(Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, s.smallest());
        assertEquals(Integer.MAX_VALUE, s.largest());
        assertEquals("[-2147483648, 0, 2147483647]", s.toString());
    }
 
    // ===== remove() =====
 
    /**
     * Remove a present element; verify it is absent and others remain.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveRemovesExistingElement() {
        // Arrange
        IntegerSet s = setOf(1, 2, 3);
        // Act
        s.remove(2);
        // Assert
        assertFalse(s.contains(2));
        assertTrue(s.contains(1));
        assertTrue(s.contains(3));
        assertEquals(2, s.length());
        assertEquals("[1, 3]", s.toString());
    }
 
    /**
     * Remove an absent element; verify the set is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveIgnoresAbsentElement() {
        // Arrange
        IntegerSet s = setOf(1, 2, 3);
        // Act
        s.remove(99);
        // Assert
        assertEquals(3, s.length());
        assertTrue(s.equals(setOf(1, 2, 3)));
        assertEquals("[1, 2, 3]", s.toString());
    }
 
    // ===== union() =====
 
    /**
     * Verify union() contains all distinct elements from two overlapping sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionOverlappingSets() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet b = setOf(3, 4, 5);
        // Act
        IntegerSet result = a.union(b);
        // Assert
        assertEquals(5, result.length());
        assertTrue(result.equals(setOf(1, 2, 3, 4, 5)));
        assertEquals("[1, 2, 3, 4, 5]", result.toString());
    }
 
    /**
     * Verify union with an empty set and with the same object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionEmptyAndSameOperand() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet empty = new IntegerSet();
        // Act
        IntegerSet withEmpty = a.union(empty);
        IntegerSet emptyWithA = empty.union(a);
        IntegerSet withSelf = a.union(a);
        // Assert
        assertTrue(withEmpty.equals(setOf(1, 2, 3)));
        assertTrue(emptyWithA.equals(setOf(1, 2, 3)));
        assertTrue(withSelf.equals(setOf(1, 2, 3)));
        assertEquals(3, withSelf.length());
        assertTrue(a.equals(setOf(1, 2, 3)));
        assertTrue(empty.isEmpty());
    }
 
    /**
     * Verify both inputs remain unchanged; modify the result and verify the inputs are still unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testUnionDoesNotMutateInputs() {
        // Arrange
        IntegerSet a = setOf(1, 2);
        IntegerSet b = setOf(2, 3);
        // Act
        IntegerSet result = a.union(b);
        // Assert: inputs unchanged after the operation
        assertNotSame(a, result);
        assertNotSame(b, result);
        assertEquals("[1, 2]", a.toString());
        assertEquals("[2, 3]", b.toString());
        // Modify the result; inputs must still be unchanged
        result.add(100);
        result.remove(1);
        result.remove(2);
        assertEquals("[3, 100]", result.toString());
        assertEquals("[1, 2]", a.toString());
        assertEquals("[2, 3]", b.toString());
    }
 
    // ===== intersect() =====
 
    /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3, 4);
        IntegerSet b = setOf(3, 4, 5, 6);
        // Act
        IntegerSet result = a.intersect(b);
        // Assert
        assertEquals(2, result.length());
        assertTrue(result.equals(setOf(3, 4)));
        assertFalse(result.contains(1));
        assertFalse(result.contains(5));
        assertEquals("[3, 4]", result.toString());

    }
 
    /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectDisjointAndSameOperand() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet disjoint = setOf(7, 8, 9);
        // Act
        IntegerSet none = a.intersect(disjoint);
        IntegerSet self = a.intersect(a);
        // Assert
        assertTrue(none.isEmpty());
        assertEquals("[]", none.toString());
        assertTrue(self.equals(setOf(1, 2, 3)));
        assertTrue(a.equals(setOf(1, 2, 3)));
    }
 
    /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet b = setOf(2, 3, 4);
        // Act
        IntegerSet result = a.intersect(b);
        assertEquals("[2, 3]", result.toString());
        result.add(50);
        result.remove(2);
        // Assert
        assertNotSame(a, result);
        assertNotSame(b, result);
        assertEquals("[3, 50]", result.toString());
        assertEquals("[1, 2, 3]", a.toString());
        assertEquals("[2, 3, 4]", b.toString());
    }
 
    // ===== diff() =====
 
    /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3, 4);
        IntegerSet b = setOf(3, 4, 5);
        // Act
        IntegerSet aMinusB = a.diff(b);
        IntegerSet bMinusA = b.diff(a);
        // Assert
        assertTrue(aMinusB.equals(setOf(1, 2)));
        assertTrue(bMinusA.equals(setOf(5)));
        assertFalse(aMinusB.equals(bMinusA));
    }
 
    /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet empty = new IntegerSet();
        // Act
        IntegerSet aMinusEmpty = a.diff(empty);
        IntegerSet emptyMinusA = empty.diff(a);
        IntegerSet aMinusA = a.diff(a);
        // Assert
        assertTrue(aMinusEmpty.equals(setOf(1, 2, 3)));
        assertTrue(emptyMinusA.isEmpty());
        assertTrue(aMinusA.isEmpty());
        assertTrue(a.equals(setOf(1, 2, 3)));
    }
 
    /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
         // Arrange
        IntegerSet a = setOf(1, 2, 3);
        IntegerSet b = setOf(3, 4);
        // Act
        IntegerSet result = a.diff(b);
        assertEquals("[1, 2]", result.toString());
        result.add(4);
        result.add(99);
        result.remove(1);
        // Assert
        assertNotSame(a, result);
        assertNotSame(b, result);
        assertEquals("[2, 4, 99]", result.toString());
        assertEquals("[1, 2, 3]", a.toString());
        assertEquals("[3, 4]", b.toString());
    }
 
    // ===== complement() =====
 
    /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        // Arrange
        // Act
        // Assert
    }
 
    // ===== isSubsetOf() =====
 
    /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        // Arrange
        // Act
        // Assert
    }
 
    // ===== isDisjoint() =====
 
    /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        // Arrange
        // Act
        // Assert
    }
 
    // ===== symmetricDiff() =====
 
    /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIdenticalSets() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        // Arrange
        // Act
        // Assert
    }
 
    // ===== isEmpty() =====
 
    /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        // Arrange
        // Act
        // Assert
    }
 
    // ===== toString() =====
 
    /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify an empty set formats as [].
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testToStringEmptyFormatting() {
        // Arrange
        // Act
        // Assert
    }
 
    /**
     * Verify comma-space formatting, brackets, and duplicate suppression.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        // Arrange
        // Act
        // Assert
    }
 
}
