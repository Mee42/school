package com.carson.pack;

public class InsuredPackage extends Package {
    public InsuredPackage(double ounces, Method shipping) {
        super(ounces, shipping);
    }

    @Override
    public double getCost() {
        return super.getCost() + getInsurceCost();
    }

    private double getInsurceCost() {
        if(super.getCost() <= 1)
            return 2.45;
        if(super.getCost() <= 3)
            return 3.95;
        return 5.55;
    }
}
