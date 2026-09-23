package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

public enum Paylevel {
    LOW("Low", new BigDecimal("500.00")),
    STANDARD("Standard", new BigDecimal("1000.00")),
    HIGH("High", new BigDecimal("2000.00")),
    EXECUTIVE("Executive", null); // no upper bound

    private final String label;
    private final BigDecimal upperBound;

 
    PayLevel(String label, BigDecimal upperBound) {
        this.label = label;
        this.upperBound = upperBound;
    }

    public static PayLevel fromGrossPay(BigDecimal grossPay) {
        for (PayLevel level : values()) {
            if (level.upperBound == null || grossPay.compareTo(level.upperBound) < 0) {
                return level;
            }
        }
        return EXECUTIVE;
    }
 
    @Override
    public String toString() {
        return label;
    }
}
