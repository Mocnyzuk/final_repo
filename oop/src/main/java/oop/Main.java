package oop;

import oop.domain.Cheese;
import oop.domain.Pizza;
import oop.domain.Sauce;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = Pizza.PizzaBuilder.aPizza(30,"Margherita", Sauce.TOMATO, Cheese.MOZZARELLA)
                .withExtraCheese(true)
                .withMushroom(true)
                .build();
    }
}
