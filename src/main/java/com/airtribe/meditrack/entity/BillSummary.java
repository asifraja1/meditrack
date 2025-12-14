package com.airtribe.meditrack.entity;

public final class BillSummary {
    private final double amount;

    public BillSummary(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}