package org.howard.edu.lsp.assignment3;

public class Employmentstatus {
    PART_TIME("Part-Time"),
    FULL_TIME("Full-Time");

    private static final double FULL_TIME_THRESHOLD = 30.00;
 
    private final String label;

    EmploymentStatus(String label) {
        this.label = label;
    }

    public static EmploymentStatus fromHours(double hoursWorked) {
        return (hoursWorked < FULL_TIME_THRESHOLD) ? PART_TIME : FULL_TIME;
    }
 
    @Override
    public String toString() {
        return label;
    }
}
