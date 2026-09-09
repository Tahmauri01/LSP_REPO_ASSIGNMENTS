package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {
    private static final String INPUT_PATH = "data/employees.csv";
    private static final String OUTPUT_PATH = "data/transformed_employees.csv";

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



}
