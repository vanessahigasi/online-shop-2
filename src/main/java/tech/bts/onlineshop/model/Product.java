package tech.bts.onlineshop.model;


public class Product {

    private String name;
    private double price;
    private boolean available;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

}
