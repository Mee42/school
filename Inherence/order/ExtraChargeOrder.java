/**
  *@author Carson Graham
  *Notes: seems redundent, but whatever
  */
public class ExtraChargeOrder extends Order {
    public ExtraChargeOrder(String customerName, int customerNumber, int quantity, double unitPrice) {
        super(customerName, customerNumber, quantity, unitPrice);
    }

    @Override
    public double computePrice() {
        return super.computePrice() + 4;
    }
}
