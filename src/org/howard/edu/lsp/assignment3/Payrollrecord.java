package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;


public class Payrollrecord {
    public static final String CSV_HEADER =
            "EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus";
 
    private final Employee employee;
    private final Bigdecimal grossPay;
    private final Paylevel payLevel;
    private final Employmentstatus employmentStatus;

}
