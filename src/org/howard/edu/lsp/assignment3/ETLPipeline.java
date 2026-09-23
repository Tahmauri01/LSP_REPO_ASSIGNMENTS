package org.howard.edu.lsp.assignment3;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ETLPipeline {
    private static final String INPUT_PATH = "data/employees.csv";
    private static final String OUTPUT_PATH = "data/transformed_employees.csv";
 
    private final EmployeeCsvReader reader;
    private final EmployeeParser parser;
    private final PayrollCalculator calculator;
    private final PayrollCsvWriter writer;
 
    public ETLPipeline(EmployeeCsvReader reader, EmployeeParser parser,
                       PayrollCalculator calculator, PayrollCsvWriter writer) {
        this.reader = reader;
        this.parser = parser;
        this.calculator = calculator;
        this.writer = writer;
    }

    public void run() {
    
        List<String> dataLines;
        try {
            dataLines = reader.readDataLines();
        } catch (IOException e) {
            System.err.println("Error reading input file '" + reader.getPath() + "': " + e.getMessage());
            return;
        }
    
        int rowsRead = dataLines.size();
        int rowsSkipped = 0;
        List<PayrollRecord> records = new ArrayList<>();
        for (String line : dataLines) {
            Optional<Employee> employee = parser.parse(line);
            if (employee.isEmpty()) {
                rowsSkipped++;
                continue;
            }
            records.add(calculator.process(employee.get()));
        }

        try {
            writer.write(records);
        } catch (IOException e) {
            System.err.println("Error writing output file '" + writer.getPath() + "': " + e.getMessage());
            return;
        }
 
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + records.size());
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + writer.getPath());
    }
    
    public static void main(String[] args) {
        ETLPipeline pipeline = new ETLPipeline(
                new EmployeeCsvReader(INPUT_PATH),
                new EmployeeParser(),
                new PayrollCalculator(),
                new PayrollCsvWriter(OUTPUT_PATH));
        pipeline.run();
    }

}