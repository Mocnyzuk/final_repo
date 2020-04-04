package oop.domain;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
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
