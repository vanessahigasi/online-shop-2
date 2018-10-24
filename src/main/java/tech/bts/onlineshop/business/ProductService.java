package tech.bts.onlineshop.business;

import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class ProductService {

    private ProductDatabase productDatabase;

    public ProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    /** Adds a product and returns the id for that product */

    public long createProduct(Product product) {
        long productId = this.productDatabase.add(product);
        return productId;
    }

    public void addProductStock (long productId, int quantity) {

        Product product = this.productDatabase.get(productId);
        System.out.println("Current quantity in stock: " + product.getQuantity());

        int total = product.getQuantity() + quantity;
        System.out.println("Now the quanity will be " + total);

        product.setQuantity(total);
    }

    public Product getProductById(long productId) {
        Product p = this.productDatabase.get(productId);
        return p;
    }

}