package org.howard.edu.lsp.assignment3;

public enum Employmentstatus {
    PART_TIME("Part-Time"),
    FULL_TIME("Full-Time");

    private static final double FULL_TIME_THRESHOLD = 30.00;
 
    private final String label;

    Employmentstatus(String label) {
        this.label = label;
    }

    public static Employmentstatus fromHours(double hoursWorked) {
        return (hoursWorked < FULL_TIME_THRESHOLD) ? PART_TIME : FULL_TIME;
    }
 
    @Override
    public String toString() {
        return label;
    }
}
