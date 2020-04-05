public class Main {
    public static void main(String[] args) {

        final AnimalImpl dog = AnimalImpl.AnimalBuilder
                .aAnimal("Tofik")
                .withCanSwim(true)
                .withIsFurry(true)
                .withLegs(4)
                .withYears(7)
                .build();

        final AnimalImpl parrot = AnimalImpl.AnimalBuilder
                .aAnimal("Filo")
                .withLegs(2)
                .build();

        final AnimalImpl parrot2 = AnimalImpl.AnimalBuilder
                .aAnimal("Filo")
                .build();

        System.out.println(parrot2);
        System.out.println();
        dog.eat();
        System.out.println();
        parrot.sleep();

    }
}
