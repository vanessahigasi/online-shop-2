package tech.bts.onlineshop;

import tech.bts.onlineshop.business.PurchaseService;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.CartItem;
import tech.bts.onlineshop.model.Product;
import tech.bts.onlineshop.model.ShoppingCart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class Example {

    public static void main(String[] args) {

        Product p1 = new  Product("MacBook", "Apple", 1500);
        Product p2 = new  Product("iphone xs","Apple", 1200);
        Product p3 = new  Product("Pixel 3","Google", 900);

        ProductDatabase productDatabase = new ProductDatabase();
        productDatabase.add(p1);
        productDatabase.add(p2);
        productDatabase.add(p3);

        System.out.println("p1 is available?" + p1.isAvailable());


        Product product = productDatabase.get(3);
        System.out.println("The name of the product is: " + product.getName());

        int count = productDatabase.getCount();
        System.out.println("I have " + count + " products in the database");

        int countApple = productDatabase.getCountByBrand("Apple");
        System.out.println("I have " + countApple + " Apple products");


        List<Product> productsByApple = productDatabase.getByBrand("Apple");
        System.out.println("Products by Apple: " + productsByApple);
        for (Product p : productsByApple) {
            System.out.println(p.getName() + ", " + p.getBrand() + ", " + p.getPrice());

        }


        List<CartItem> items1 = new ArrayList<>();

        items1.add(new CartItem(p1,2));
        items1.add(new CartItem(p2,3));
        items1.add(new CartItem(p3,1));

        ShoppingCart cart = new ShoppingCart(items1);

        PurchaseService purchaseService = new PurchaseService();

        double total = purchaseService.calculateTotalAmount(cart);

        System.out.println("total = " + total);

        productDatabase.getCount();

        List<Product> productsByPrice = productDatabase.getByPriceRange(500,1300);

        for (Product p : productsByPrice) {
            System.out.println( p.getName() + ", " + p.getBrand() + ", " + p.getPrice());
        }

        System.out.println("Products by price, all of them " + productsByPrice);

        productDatabase.remove(2);
        productDatabase.remove(3);

        System.out.println("All products after removing one: ");

        Collection<Product> allProducts = productDatabase.getAll();
        for (Product p : allProducts) {
            System.out.println(p);
        }

        Product p4 = new Product("lightning cable", "Apple", 10);
        productDatabase.add(p4);

        System.out.println( "Number of products now: " + productDatabase.getCount());

        long requestedId = 1;
        Product requestedProduct = productDatabase.get(requestedId);

        //if the requested product exists, write "the name of the product is XXX"
        //if it doesn't write "the product with ID doesn't exist"

        if (requestedProduct !=  null) {
            System.out.println("The name of the product is " + requestedProduct.getName());
        } else {
            System.out.println("The product with ID " + requestedId + " doesn't exist");

        }



    }
}