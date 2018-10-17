package tech.bts.onlineshop;

public class Product {

    private String name;
    private Double price;
    private boolean available;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

}
