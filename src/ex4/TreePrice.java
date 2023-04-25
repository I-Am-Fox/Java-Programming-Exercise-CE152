package ex4;

public class TreePrice implements Comparable<TreePrice> {
    private PriceDate priceDate; // variable to store the price date
    private double nominalPrice; // variable to store the nominal price
    private double realPrice; // variable to store the real price

    public TreePrice(PriceDate priceDate, double nominalPrice, double realPrice) {
        this.priceDate = priceDate;
        this.nominalPrice = nominalPrice;
        this.realPrice = realPrice;
    }

    public PriceDate getPriceDate() {
        return priceDate;
    }

    public double getNominalPrice() {
        return nominalPrice;
    }

    public double getRealPrice() {
        return realPrice;
    }

    @Override
    public int compareTo(TreePrice other) {
        return this.priceDate.compareTo(other.priceDate);
    }

    @Override
    public String toString() {
        return String.format("%s Nominal: %.1f Real: %.1f", priceDate.toString(), nominalPrice, realPrice);
    }
}
