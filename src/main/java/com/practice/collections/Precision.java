package com.practice.collections;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Precision {

    static final String formatAmount(double amount, int precision) {
        BigDecimal bgAmount = new BigDecimal(Double.toString(amount));
        bgAmount = bgAmount.multiply(BigDecimal.valueOf(Math.pow(10, precision)));
        BigInteger bgInt = bgAmount.toBigInteger();
        bgAmount = new BigDecimal(bgInt, precision);
        return bgAmount.toString();
    }
}
