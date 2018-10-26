package tech.bts.onlineshop.business;

import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class ProductServiceTest {

    public static void main(String[] args) {

        empty_catalogs_has_no_products();
        add_products_to_catalog();
        product_avalability();
        product_available_quantity();

    }


    private static void empty_catalogs_has_no_products() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);

        int count = productService.getCount();
        //System.out.println("0 --> " + count);
        assertEquals(count,0);
    }

    private static void add_products_to_catalog() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        long pixelId = productService.createProduct(new Product("pixel","Google",800));
        int count = productService.getCount();
        assertEquals(count,1);
        Product p = productService.getProductById(pixelId);
        //System.out.println("pixel --> " + p.getName());
        assertEquals(p.getName(),"pixel");

    }

    private static void product_avalability() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        long pixelId = productService.createProduct(new Product("pixel","Google",800));

        boolean availableBefore = productService.checkProductAvailability(pixelId,500);
        assertEquals(availableBefore, false);

        productService.addProductStock(pixelId,500);

        boolean availableAfter = productService.checkProductAvailability(pixelId,500);
        assertEquals(availableAfter, true);
    }


    /** Compares the values and display an error if they are not */
    private static void assertEquals(Object s1, Object s2) {

        if (!s1.equals(s2)) {
            //System.out.println(s1 + " is not equal to " + s2);
            throw new RuntimeException(s1 + " is not equal to " + s2);
        }
    }

    private static void product_available_quantity() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        long tvId = productService.createProduct(new Product("pixel","Google",800));

        assertEquals(productService.getAvailableQuantity(tvId,50), 0);

        productService.addProductStock(tvId,100);

        assertEquals(productService.getAvailableQuantity(tvId,50), 50);
        assertEquals(productService.getAvailableQuantity(tvId,200), 100);

    }
}
