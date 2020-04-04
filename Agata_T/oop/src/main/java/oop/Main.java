package oop;

import lombok.With;
import oop.domain.Cheese;
import oop.domain.Meat;
import oop.domain.Pizza;
import oop.domain.Sauce;

public class Main {
    public static void main(String[] args) {

        Pizza margherita = Pizza.builder()
                .sizeInCM(30)
                .type("margherita")
                .sauce(Sauce.TOMATO)
                .cheese(Cheese.MOZZARELLA)
                .tomato(true)
                .build();

        Pizza pepperoni = Pizza.builder()
                .sizeInCM(20)
                .type("pepperoni")
                .sauce(Sauce.SALSA)
                .cheese(Cheese.PARMESAN)
                .meat(Meat.PEPPERONI)
                .mushroom(true)
                .olive(true)
                .build();


        System.out.println(margherita.toString());
        System.out.println(pepperoni.toString());
    }
}
