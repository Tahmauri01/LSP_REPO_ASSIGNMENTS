package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ETLPipeline {
    private static final String INPUT_PATH = "data/employees.csv";
    private static final String OUTPUT_PATH = "data/transformed_employees.csv";
    private static final double OVERTIME_THRESHOLD = 40.00;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final double IT_BONUS_RATE = 0.05;
    private static final double FULL_TIME_THRESHOLD = 30.00;

    private static class TransformedRecord {
        int employeeId;
        String name;
        String department;
        double hoursWorked;
        double hourlyRate;
        BigDecimal grossPay;
        String payLevel;
        String employmentStatus;
    }

    public static void main(String[] args) {
        
        int rowsRead = 0;
        int rowsSkipped = 0;

        List<String[]> rawRecords = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String line;
            boolean isHeader = true;


            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                    rowsRead++;

                if (line.isBlank()) {
                    rowsSkipped++;
                    continue;
                }
 
                String[] fields = line.split(",", -1);
                if (fields.length != 5) {
                    rowsSkipped++;
                    continue;
                }

                rawRecords.add(fields);

    }



        }  catch (IOException e) {
            System.err.println("Error reading input file '" + INPUT_PATH + "': " + e.getMessage());
            return;
        }

        List<TransformedRecord> transformedRecords = new ArrayList<>();
 
        for (String[] fields : rawRecords) {
            String rawId = fields[0].trim();
            String name = fields[1].trim().toUpperCase();
            String department = fields[2].trim();
            String rawHours = fields[3].trim();
            String rawRate = fields[4].trim();


            int employeeId;
            double hoursWorked;
            double hourlyRate;


            try {
                employeeId = Integer.parseInt(rawId);
            } catch (NumberFormatException e) {
                rowsSkipped++;
                continue;
            }
 
            try {
                hoursWorked = Double.parseDouble(rawHours);
            } catch (NumberFormatException e) {
                rowsSkipped++;
                continue;
            }
 
            try {
                hourlyRate = Double.parseDouble(rawRate);
            } catch (NumberFormatException e) {
                rowsSkipped++;
                continue;
            }
 
            if (hoursWorked < 0 || hourlyRate < 0) {
                rowsSkipped++;
                continue;
            }
        }
    }


}

