package org.howard.edu.lsp.midterm.inheritance;

/**
 * A part-time employee who receives straight hourly pay.
 * @author Tahmauri Bobo
 */
public class PartTimeEmployee extends Employee {
 
    /**
     * Creates a part-time employee.
     * @param hoursWorked hours worked this week
     * @param hourlyRate pay per hour
     */
    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }
 
    /**
     * Calculates straight hourly pay.
     * @return hours worked times hourly rate
     */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate();
    }
}