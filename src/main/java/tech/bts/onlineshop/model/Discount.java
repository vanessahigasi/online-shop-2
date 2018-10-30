package tech.bts.onlineshop.model;

public class Discount {

    private String  id;
    private String name;
    private double amount;
    private boolean percentage;

    public Discount(String id, String name, double amount, boolean percentage) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.percentage = percentage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPercentage() {
        return percentage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }

    public String getid() {
    }
}
