package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.interfaces.Payable;

public class Bill extends MedicalEntity implements Payable {

    private final double baseAmount;

    public Bill(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Override
    public double generateBill() {
        return baseAmount + (baseAmount * Constants.TAX_RATE);
    }

    @Override
    public void pay() {
        System.out.println("Payment successful");
    }
}