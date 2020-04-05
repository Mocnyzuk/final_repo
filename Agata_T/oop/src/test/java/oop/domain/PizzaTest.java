package oop.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    @DisplayName("if pizza is build properly by lombok builder")
    void buildPizza() {
        //given
        Pizza margherita= new Pizza();
        margherita.setSizeInCM(30);
        margherita.setType("margherita");
        margherita.setCheese(Cheese.MOZZARELLA);
        margherita.setSauce(Sauce.TOMATO);
        margherita.setTomato(true);

        //when
        Pizza margheritaBuilder = Pizza.builder()
                .sizeInCM(30)
                .type("margherita")
                .sauce(Sauce.TOMATO)
                .cheese(Cheese.MOZZARELLA)
                .tomato(true)
                .build();
        //then
        assertEquals(margherita, margheritaBuilder);
    }
}