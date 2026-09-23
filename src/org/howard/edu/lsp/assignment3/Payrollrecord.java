package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;


public class Payrollrecord {
    public static final String CSV_HEADER =
            "EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus";
 
    private final Employee employee;
    private final Bigdecimal grossPay;
    private final Paylevel payLevel;
    private final Employmentstatus employmentStatus;

    public Payrollrecord(Employee employee, Bigdecimal grossPay,
                         Paylevel payLevel, Employmentstatus employmentStatus) {
        this.employee = employee;
        this.grossPay = grossPay;
        this.payLevel = payLevel;
        this.employmentStatus = employmentStatus;
    }

    public Employee getEmployee() { return employee; }
    public BigDecimal getGrossPay() { return grossPay; }
    public Paylevel getPayLevel() { return payLevel; }
    public Employmentstatus getEmploymentStatus() { return employmentStatus; }
 
    public String toCsvRow() {
        return String.format("%d,%s,%s,%.2f,%.2f,%.2f,%s,%s",
                employee.getEmployeeId(), employee.getName(), employee.getDepartment(),
                employee.getHoursWorked(), employee.getHourlyRate(),
                grossPay, payLevel, employmentStatus);
    }

}
