package oop.domain;

import lombok.*;

/**
 * Represents a pizza. Implemented builder design pattern using Lombok.
 * */
@Builder
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    private int sizeInCM;
    private String type;
    private Sauce sauce;
    private Meat meat;
    private Cheese cheese;
    private boolean extraCheese;
    private boolean tomato;
    private boolean mushroom;
    private boolean olive;
}
