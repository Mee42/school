package com.carson.pack;

public class Package {
    private final double ounces;
    public enum Method{
        AIR(2,3,4.5),
        TRUCK(1.5,2.35,3.25),
        MAIL(.5,1.5,2.15);
        private final double low;
        private final double mid;
        private final double high;

        Method(double low, double mid, double high) {
            this.low = low;
            this.mid = mid;
            this.high = high;
        }

        public double getCost(double ounces){
            if(ounces <= 8)
                return low;
            if(ounces <= 16)
                return mid;
            return high;
        }
    }
    private final Method shipping;

    public Package(double ounces, Method shipping) {
        this.ounces = ounces;
        this.shipping = shipping;
    }

    public double getCost(){
        return shipping.getCost(ounces);
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tshipping method:" + shipping + ",\n" +
                "\tounces:" + ounces + ",\n" +
                "\tcost:" + getCost() + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        return toString().equals(o.toString());
    }
}
