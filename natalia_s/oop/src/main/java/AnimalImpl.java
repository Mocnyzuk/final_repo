public class AnimalImpl implements Animal {

    private String name;
    private boolean canSwim;
    private boolean isFurry;
    private int legs;
    private double years;

    private AnimalImpl(String name) {
        this.name = name;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public void setIsFurry(boolean isFurry) {
        this.isFurry = isFurry;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setYears(double years) {
        this.years = years;
    }

    public static class AnimalBuilder {
        private String name;
        private boolean canSwim;
        private boolean isFurry;
        private int legs;
        private double years;

        private AnimalBuilder(String name) {
            this.name = name;
        }

        public static AnimalBuilder aAnimal(String name) {
            return new AnimalBuilder(name);
        }

        public AnimalBuilder withCanSwim(boolean canSwim) {
            this.canSwim = canSwim;
            return this;
        }

        public AnimalBuilder withIsFurry(boolean isFurry) {
            this.isFurry = isFurry;
            return this;
        }

        public AnimalBuilder withLegs(int legs) {
            this.legs = legs;
            return this;
        }

        public AnimalBuilder withYears(double years) {
            this.years = years;
            return this;
        }

        public AnimalImpl build() {
            AnimalImpl animal = new AnimalImpl(name);
            animal.setCanSwim(canSwim);
            animal.setIsFurry(isFurry);
            animal.setLegs(legs);
            animal.setYears(years);
            return animal;
        }
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating now.");
    }

    @Override
    public void sleep() {
        System.out.println("Shh... your friend " + name + " needs some sleep.");
    }

    @Override
    public String toString() {
        return name + " \n can swim: " + canSwim + ", \n is furry: " + isFurry + ", \n has " + legs + " leg(s), \n is " + years + " year(s) old";
    }

}