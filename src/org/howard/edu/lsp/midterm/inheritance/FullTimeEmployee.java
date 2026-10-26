package org.howard.edu.lsp.midterm.inheritance;

/**
 * A full-time employee: straight pay for the first 40 hours, then 1.5 times the hourly rate for overtime hours.
 * @author Tahmauri Bobo
 */
public class FullTimeEmployee extends Employee {
    private static final double REGULAR_HOURS = 40.0;
    private static final double OVERTIME_MULTIPLIER = 1.5;
 
    /**
     * Creates a full-time employee.
     * @param hoursWorked hours worked this week
     * @param hourlyRate  pay per hour
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
 
    /**
     * Calculates pay including overtime beyond 40 hours.
     * @return regular pay plus overtime pay
     */
    @Override
    public double calculatePay() {
        double hours = getHoursWorked();
        double rate = getHourlyRate();
        double regular = Math.min(hours, REGULAR_HOURS);
        double overtime = Math.max(0, hours - REGULAR_HOURS);
        return regular * rate + overtime * rate * OVERTIME_MULTIPLIER;
    }
}