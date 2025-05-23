package com.example.BookStore.Domain;

import java.math.BigDecimal;
import java.util.HashMap;

import lombok.Data;


@Data
public class Cart {
    

    private HashMap<Book, Integer> myCart;


    public Cart() {
        myCart = new HashMap<>();
    }


    public HashMap<Book, Integer> getMyCart() {
        return myCart;
    }


    public void addItem(Book book) {

        if (myCart.containsKey(book)) {
            myCart.put(book, myCart.get(book) + 1);
        } else {
            myCart.put(book, 1);
        }
    }

    
    
    public void decreaseItemValue(Book book) {

        if (myCart.containsKey(book)) {

            if (myCart.get(book) == 1) {
                myCart.remove(book);
            } else {
                myCart.put(book, myCart.get(book) - 1);
            }
        } 
    }


    public void clearCart() {
        myCart.clear();
    }


    public double getTotal() {
        double total = 0;
        for (Book key: myCart.keySet()) {
            total +=  key.getPrice().doubleValue() * myCart.get(key) ;
        }
        return total;
    }


}

