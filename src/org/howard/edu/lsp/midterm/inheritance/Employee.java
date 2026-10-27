package org.howard.edu.lsp.midterm.inheritance;

/**
 * Abstract base class for all employee types. Stores hours worked and
 * hourly rate; each subclass overrides {@link #calculatePay()} with its
 * own pay rule.
 * @author Tahmauri Bobo
 */
public abstract class Employee {
    private final double hoursWorked;
    private final double hourlyRate;

    /**
     * Creates an employee.
     * @param hoursWorked hours worked this week (nonnegative)
     * @param hourlyRate  pay per hour (nonnegative)
     */
    public Employee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Returns the hours worked.
     * @return hours worked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Returns the hourly rate.
     * @return hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Calculates this employee's pay.
     * @return the pay amount
     */
    public abstract double calculatePay();

}
