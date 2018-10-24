package tech.bts.onlineshop.business;

import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class ProductService {

    private ProductDatabase productDatabase;

    public ProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public void createProduct(Product product) {
        this.productDatabase.add(product);

    }
    public void addProductStock (long productId, int quantity) {

        Product product = this.productDatabase.get(productId);
        System.out.println("Current quantity in stock: " + product.getQuantity());

        int total = product.getQuantity() + quantity;
        System.out.println("Now the quanity will be " + total);

        product.setQuantity(total);
    }

}
