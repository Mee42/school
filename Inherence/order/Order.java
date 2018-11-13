package com.carson.order;

public class Order {
    private final String customerName;
    private final int customerNumber;
    private final int quantity;
    private final double unitPrice;

    public Order(String customerName, int customerNumber, int quantity, double unitPrice) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }


    public double computePrice(){
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tcustomerName:\"" + customerName + "\",\n" +
                "\tcustomerNumber:\"" + customerNumber + "\",\n" +
                "\tquantity:\"" + quantity + "\",\n" +
                "\tunitPrice:\"" + unitPrice + "\",\n}";
    }


    @Override
    public boolean equals(Object o) {
         return toString().equals(o.toString());//if values are the same, #toString will be the same, so this is an easier way to write this method
    }
}
