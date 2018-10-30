package tech.bts.onlineshop.business;

import tech.bts.onlineshop.model.Discount;

import java.util.HashMap;
import java.util.Map;

public class DiscountService {

    private String id;

    private Map<String, Discount> discountMap;

    public DiscountService() {
        this.discountMap = new HashMap<>();
    }

    public void createDiscount (Discount discount) {

        discountMap.put(discount.getid(),discount);

    }

    public double discountFinalAmount (String id, double amount) {

        Discount discount = this.discountMap.get(id);
        if () {

        }


    }
}
