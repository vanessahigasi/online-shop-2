package tech.bts.onlineshop;

import tech.bts.onlineshop.business.ProductService;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.CartItem;
import tech.bts.onlineshop.model.Product;
import tech.bts.onlineshop.model.ShoppingCart;

public class Example2 {

    public static void main(String[] args) {



        ProductDatabase productDatabase = new ProductDatabase();

        ProductService productService = new ProductService(productDatabase);
        long xiaomiId = productService.createProduct(new Product("A1", "Xiaomi", 250));
        long iphoneId = productService.createProduct(new Product("iPhone XS", "Apple", 1250));
        long pixelId = productService.createProduct(new Product("Pixel 3", "Google", 900));

        productService.addProductStock(iphoneId,100);
        productService.addProductStock(iphoneId,200);
        productService.addProductStock(pixelId,150);

        Product p = productService.getProductById(xiaomiId);
        System.out.println("There are " + p.getQuantity() + " units of " + p.getName() + " in stock");

        ShoppingCart cart = new ShoppingCart();
        cart.add(new CartItem(iphoneId,20));
        cart.add(new CartItem(pixelId,50));

        productService.purchase(cart);

        Product iPhone = productService.getProductById(iphoneId);
        System.out.println("expected 280 --> " + iPhone.getQuantity());

        Product pixel = productService.getProductById(pixelId);
        System.out.println("expected 100  --> " + pixel.getQuantity());

        Product xiaomi = productService.getProductById(xiaomiId);
        System.out.println("expected 0 --> " + xiaomi.getQuantity());
    }
}
