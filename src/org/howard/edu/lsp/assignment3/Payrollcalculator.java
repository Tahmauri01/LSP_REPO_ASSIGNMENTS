package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Payrollcalculator {
    private static final double OVERTIME_THRESHOLD = 40.00;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final String BONUS_DEPARTMENT = "IT";
    private static final double IT_BONUS_RATE = 0.05;

    public Payrollrecord process(Employee employee) {
        BigDecimal grossPay = calculateGrossPay(employee);
        return new Payrollrecord(
                employee,
                grossPay,
                PayLevel.fromGrossPay(grossPay),
                EmploymentStatus.fromHours(employee.getHoursWorked()));
    }

}
