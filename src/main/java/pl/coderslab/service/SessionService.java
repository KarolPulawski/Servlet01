package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public class SessionService {

    public static Product createProduct(String name, int amount, double price) {
        return new Product(name, amount, price);
    }

    public static double basketTotal(List<Product> list) {
        double total = 0.0;
        for(Product prod : list) {
            total += prod.getPrice() * prod.getAmount();
        }
        return total;
    }


}

