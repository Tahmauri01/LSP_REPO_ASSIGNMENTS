package org.howard.edu.lsp.assignment3;

import java.util.Optional;

public class EmployeeParser {
    private static final int EXPECTED_FIELDS = 5;

    public Optional<Employee> parse(String line) {
        if (line.isBlank()) {
            return Optional.empty();
        }
 
        String[] fields = line.split(",", -1);
        if (fields.length != EXPECTED_FIELDS) {
            return Optional.empty();
        }
 
        String name = fields[1].trim().toUpperCase();
        String department = fields[2].trim();
 
        int employeeId;
        double hoursWorked;
        double hourlyRate;
        try {
            employeeId = Integer.parseInt(fields[0].trim());
            hoursWorked = Double.parseDouble(fields[3].trim());
            hourlyRate = Double.parseDouble(fields[4].trim());
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
 
        if (hoursWorked < 0 || hourlyRate < 0) {
            return Optional.empty();
        }

        return Optional.of(new Employee(employeeId, name, department, hoursWorked, hourlyRate));
    }
}
