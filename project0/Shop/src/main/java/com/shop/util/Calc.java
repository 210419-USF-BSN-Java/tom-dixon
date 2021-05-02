package com.shop.util;

public class Calc {
    public static String paymentAmount(int weeks, double difference, double interestRate) {
        return String.format("%.2f", ((difference + difference * interestRate) / weeks));
    }
}
