import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalImplTest {

    @Test
    void showAnimal() {

        //given
        final AnimalImpl parrot = AnimalImpl.AnimalBuilder
                .aAnimal("Filo")
                .withLegs(2)
                .build();

        final AnimalImpl snake = AnimalImpl.AnimalBuilder
                .aAnimal("Garry")
                .build();

        final AnimalImpl dog = AnimalImpl.AnimalBuilder
                .aAnimal("Libi")
                .withCanSwim(true)
                .withIsFurry(true)
                .withLegs(4)
                .withYears(7)
                .build();

        //when
        final String parrot_exp = "Filo \n can swim: false, \n is furry: false, \n has 2 leg(s), \n is 0.0 year(s) old";
        final String snake_exp = "Garry \n can swim: false, \n is furry: false, \n has 0 leg(s), \n is 0.0 year(s) old";
        final String dog_exp = "Libi \n can swim: true, \n is furry: true, \n has 4 leg(s), \n is 7.0 year(s) old";

        //then
        assertEquals(parrot_exp, parrot.toString());
        assertEquals(snake_exp, snake.toString());
        assertEquals(dog_exp, dog.toString());

    }
}