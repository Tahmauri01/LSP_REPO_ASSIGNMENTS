package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;


public class PayrollRecord {
    public static final String CSV_HEADER =
            "EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus";
 
    private final Employee employee;
    private final BigDecimal grossPay;
    private final PayLevel payLevel;
    private final EmploymentStatus employmentStatus;

    public PayrollRecord(Employee employee, BigDecimal grossPay,
                         PayLevel payLevel, EmploymentStatus employmentStatus) {
        this.employee = employee;
        this.grossPay = grossPay;
        this.payLevel = payLevel;
        this.employmentStatus = employmentStatus;
    }

    public Employee getEmployee() { return employee; }
    public BigDecimal getGrossPay() { return grossPay; }
    public PayLevel getPayLevel() { return payLevel; }
    public EmploymentStatus getEmploymentStatus() { return employmentStatus; }
 
    public String toCsvRow() {
        return String.format("%d,%s,%s,%.2f,%.2f,%.2f,%s,%s",
                employee.getEmployeeId(), employee.getName(), employee.getDepartment(),
                employee.getHoursWorked(), employee.getHourlyRate(),
                grossPay, payLevel, employmentStatus);
    }

}
