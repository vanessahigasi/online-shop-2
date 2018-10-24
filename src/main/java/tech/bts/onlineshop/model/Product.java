package tech.bts.onlineshop.model;


public class Product {

    private long id;
    private String name;
    private String brand;
    private double price;
    private boolean available;


    //In Java, constants are written in upper case, by convention
    public final static long NOT_SPECIFIED = -1;

    public Product(String  name, String brand,int price) {
        this.id = NOT_SPECIFIED;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.available = true;

    }

    @Override
    public String toString() {
        return this.name + " : " + this.price + "€";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
