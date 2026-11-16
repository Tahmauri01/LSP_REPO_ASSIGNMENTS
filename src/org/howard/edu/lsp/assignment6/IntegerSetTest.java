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
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Clear an already empty set; verify it remains empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsEmptySet() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== length() =====
 
    /**
     * Add repeated and unique integers; assert the number of distinct elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthCountsUniqueElements() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== equals() =====
 
    /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsIgnoresInsertionOrder() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Construct sets of equal length with different elements; assert inequality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsDetectsDifferentContents() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsEmptySetsEqual() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsSameObjectAndDifferentSizes() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== contains() =====
 
    /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsPresentAndAbsent() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify an empty set does not contain an arbitrary integer.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsEmptySetContainsNothing() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== largest() =====
 
    /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== smallest() =====
 
    /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== add() =====
 
    /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== remove() =====
 
    /**
     * Remove a present element; verify it is absent and others remain.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveRemovesExistingElement() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Remove an absent element; verify the set is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveIgnoresAbsentElement() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== union() =====
 
    /**
     * Verify union() contains all distinct elements from two overlapping sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionOverlappingSets() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify union with an empty set and with the same object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionEmptyAndSameOperand() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify both inputs remain unchanged; modify the result and verify the inputs are still unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testUnionDoesNotMutateInputs() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== intersect() =====
 
    /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectDisjointAndSameOperand() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== diff() =====
 
    /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== complement() =====
 
    /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== isSubsetOf() =====
 
    /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== isDisjoint() =====
 
    /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== symmetricDiff() =====
 
    /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIdenticalSets() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== isEmpty() =====
 
    /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    // ===== toString() =====
 
    /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify an empty set formats as [].
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testToStringEmptyFormatting() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
    /**
     * Verify comma-space formatting, brackets, and duplicate suppression.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        // TODO: Arrange - create the required IntegerSet objects.
        // TODO: Act - invoke the operation being tested.
        // TODO: Assert - verify the expected behavior with JUnit assertions.
    }
 
}
