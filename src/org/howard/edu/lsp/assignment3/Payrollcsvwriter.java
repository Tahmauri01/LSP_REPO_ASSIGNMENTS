package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Payrollcsvwriter {
    private final String path;
 
    public Payrollcsvwriter(String path) {
        this.path = path;
    }
 
    public String getPath() {
        return path;
    }

    public void write(List<Payrollrecord> records) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.println(Payrollrecord.CSV_HEADER);
            for (Payrollrecord record : records) {
                writer.println(record.toCsvRow());
            }
        }


    }
}
