package tech.bts.onlineshop.business;

import org.junit.Assert;
import org.junit.Test;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class ProductServiceTest {


    @Test
    public void empty_catalogs_has_no_products() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);

        int count = productService.getCount();
        //System.out.println("0 --> " + count);
        Assert.assertEquals(0,count);
    }

    @Test
    public void add_products_to_catalog() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        long pixelId = productService.createProduct(new Product("pixel","Google",800));
        int count = productService.getCount();
        Assert.assertEquals(1,count);
        Product p = productService.getProductById(pixelId);
        //System.out.println("pixel --> " + p.getName());
        Assert.assertEquals("pixel",p.getName());

    }

    @Test
    public void product_availability() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        long pixelId = productService.createProduct(new Product("pixel","Google",800));

        boolean availableBefore = productService.checkProductAvailability(pixelId,500);
        Assert.assertEquals(availableBefore, false);

        productService.addProductStock(pixelId,500);

        boolean availableAfter = productService.checkProductAvailability(pixelId,500);
        Assert.assertEquals(true, availableAfter);
    }


    @Test
    public void product_available_quantity() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        long pixelId = productService.createProduct(new Product("pixel","Google",800));

        Assert.assertEquals(0, productService.getAvailableQuantity(pixelId,50));

        productService.addProductStock(pixelId,100);

        Assert.assertEquals(50, productService.getAvailableQuantity(pixelId,50));
        Assert.assertEquals(100, productService.getAvailableQuantity(pixelId,200));

    }
}
