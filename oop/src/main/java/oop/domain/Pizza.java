package oop.domain;

public class Pizza {
    private int sizeInCM;
    private String type;
    private Sauce sauce;
    private Meat meat;
    private Cheese cheese;
    private boolean extraCheese;
    private boolean tomato;
    private boolean mushroom;
    private boolean onion;

    private Pizza(int sizeInCM, String type, Sauce sauce, Cheese cheese) {
        this.sizeInCM = sizeInCM;
        this.type = type;
        this.sauce = sauce;
        this.cheese = cheese;
    }

    public int getSizeInCM() {
        return sizeInCM;
    }

    public String getType() {
        return type;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Meat getMeat() {
        return meat;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public boolean getExtraCheese() {
        return extraCheese;
    }

    public boolean getTomato() {
        return tomato;
    }

    public boolean getMushroom() {
        return mushroom;
    }

    public boolean getOnion() {
        return onion;
    }

    public void setSizeInCM(int sizeInCM) {
        this.sizeInCM = sizeInCM;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public void setMushroom(boolean mushroom) {
        this.mushroom = mushroom;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public static class PizzaBuilder {
        private int sizeInCM;
        private String type;
        private Sauce sauce;
        private Meat meat;
        private Cheese cheese;
        private boolean extraCheese;
        private boolean tomato;
        private boolean mushroom;
        private boolean onion;

        private PizzaBuilder(int sizeInCM, String type, Sauce sauce, Cheese cheese) {
            this.sizeInCM = sizeInCM;
            this.type = type;
            this.sauce = sauce;
            this.cheese = cheese;
        }

        public static PizzaBuilder aPizza(int sizeInCM, String type, Sauce sauce, Cheese cheese) {
            return new PizzaBuilder(sizeInCM, type, sauce, cheese);
        }

        public PizzaBuilder withMeat(Meat meat) {
            this.meat = meat;
            return this;
        }

        public PizzaBuilder withExtraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public PizzaBuilder withTomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public PizzaBuilder withMushroom(boolean mushroom) {
            this.mushroom = mushroom;
            return this;
        }

        public PizzaBuilder withOnion(boolean onion) {
            this.onion = onion;
            return this;
        }

        public Pizza build() {
            Pizza pizza = new Pizza(sizeInCM, type, sauce, cheese);
            pizza.setMeat(meat);
            pizza.setExtraCheese(extraCheese);
            pizza.setTomato(tomato);
            pizza.setMushroom(mushroom);
            pizza.setOnion(onion);
            return pizza;
        }
    }
}
