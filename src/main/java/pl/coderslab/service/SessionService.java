package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public class SessionService {

    public static Product createProduct(String name, int amount, double price) {
        return new Product(name, amount, price);
    }

//    public static List<Book> setBooks(int bookNumber) {
//
//    }
}

