package com.carson.order;

public class ExtraChargeOrder extends Order {
    public ExtraChargeOrder(String customerName, int customerNumber, int quantity, double unitPrice) {
        super(customerName, customerNumber, quantity, unitPrice);
    }

    @Override
    public double computePrice() {
        return super.computePrice() + 4;
    }
}
