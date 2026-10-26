package org.howard.edu.lsp.midterm.inheritance;

/**
 * A contractor who receives a 15% premium on all hours worked.
 * @author Tahmauri Bobo
 */
public class Contractor extends Employee {
    private static final double PREMIUM = 1.15;
 
    /**
     * Creates a contractor.
     * @param hoursWorked hours worked this week
     * @param hourlyRate pay per hour
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
 
    /**
     * Calculates pay with a 15% premium.
     * @return hours worked times hourly rate times 1.15
     */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate() * PREMIUM;
    }
}
