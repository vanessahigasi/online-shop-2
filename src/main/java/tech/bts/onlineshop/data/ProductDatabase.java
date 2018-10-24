package tech.bts.onlineshop.data;

import tech.bts.onlineshop.model.Product;

import java.util.*;

public class ProductDatabase {

    private long nextId;

    private Map<Long,Product> productMap;

    public ProductDatabase() {
        this.nextId = 1;
        this.productMap = new HashMap<>();

    }


    /** Adds a product to the database and returns the id that was set to it*/
    public long add(Product product) {

        product.setId(this.nextId);

        productMap.put(product.getId(),product);
        this.nextId ++;
        return product.getId();

    }


    public Product get(long id) {

        Product product = productMap.get(id);
        return product;

    }

    public int getCount () {

        return productMap.size();

    }


    /**
     * Given 2 prices (min, max) returns a list
     * of products that are in that price range (included)
     * @param minPrice
     * @param maxPrice
     * @return
     */

    public List<Product> getByPriceRange (double minPrice, double maxPrice) {

        List<Product> result = new ArrayList<>();

        for (Product product : productMap.values()) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }


    /**
     * Given an id, removes that product from the database
     * Returns the product that was removed
     */

    public void remove(long id) {

        productMap.remove(id);
    }

    public Collection<Product> getAll() {

       return productMap.values();
    }


    //method getByBrand that returns a list of products (of that brand)

    public List<Product> getByBrand (String brand) {
        List<Product> result = new ArrayList<>();

        for (Product product : productMap.values()) {
            if (product.getBrand().equals(brand)) {
                result.add(product);
            }
        }
        return result;
    }


    public int getCountByBrand(String brand) {

        List<Product> products = getByBrand(brand);
        return products.size(); //number
    }

}
