package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PayrollCsvWriter {
    private final String path;
 
    public PayrollCsvWriter(String path) {
        this.path = path;
    }
 
    public String getPath() {
        return path;
    }

    public void write(List<PayrollRecord> records) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.println(PayrollRecord.CSV_HEADER);
            for (PayrollRecord record : records) {
                writer.println(record.toCsvRow());
            }
        }


    }
}
