package co.edu.uptc.model;

public class Product implements Comparable<Product>{
    private String description;
    private double price;
    private String unitMeasurement;
    
    public Product(String description, double price, String unitMeasurement) {
        this.description = description;
        this.price = price;
        this.unitMeasurement = unitMeasurement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    @Override
    public int compareTo(Product other) {
        return this.description.compareTo(other.description);
    }

    
}
