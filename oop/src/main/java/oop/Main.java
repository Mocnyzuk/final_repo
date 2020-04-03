package oop;

import lombok.With;
import oop.domain.Cheese;
import oop.domain.Meat;
import oop.domain.Pizza;
import oop.domain.Sauce;

public class Main {
    public static void main(String[] args) {

        Pizza pizza1 = Pizza.PizzaBuilder.aPizza(30,"Margherita", Sauce.TOMATO, Cheese.MOZZARELLA)
                .withExtraCheese(true)
                .withMushroom(true)
                .build();

        Pizza pizza2 = Pizza.PizzaBuilder.aPizza(20, "Pepperoni", Sauce.SALSA, Cheese.PARMESAN)
                .withMeat(Meat.PEPPERONI)
                .withMeat(Meat.HAM)
                .withMushroom(true)
                .withTomato(true)
                .build();

        System.out.println(pizza2.toString());
    }
}
