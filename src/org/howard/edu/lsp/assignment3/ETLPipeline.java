package org.howard.edu.lsp.assignment3;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ETLPipeline {
    private static final String INPUT_PATH = "data/employees.csv";
    private static final String OUTPUT_PATH = "data/transformed_employees.csv";

    private final Employeecsvreader reader;
    private final Employeeparser parser;
    private final Payrollcalculator calculator;
    private final Payrollcsvwriter writer;

    public ETLPipeline(Employeecsvreader reader, Employeeparser parser,
                       Payrollcalculator calculator, Payrollcsvwriter writer) {
        this.reader = reader;
        this.parser = parser;
        this.calculator = calculator;
        this.writer = writer;

}