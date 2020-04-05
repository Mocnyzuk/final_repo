package spring.spring;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SmoothieRepositoryTest {

    @Test
    void findByName() {
        //given
        String name = "berries";
        Smoothie expectedSmoothie = (new Smoothie(name, "large"));

        //when
        Application.repository.save(new Smoothie("berries", "large"));
        Smoothie actualSmoothie = Application.repository.findByName(name);

        //then
        assertEquals(expectedSmoothie, actualSmoothie);
    }
        @Test
        void findBySize () {
            //given
            String size = "medium";
            Smoothie sweetSmoothie = new Smoothie("sweet", "medium");
            Smoothie freshSmoothie = new Smoothie("fresh", "medium");
            List<Smoothie> expectedSmoothies = new ArrayList<Smoothie>(){};
            expectedSmoothies.add(sweetSmoothie);
            expectedSmoothies.add(freshSmoothie);

            //when
            Application.repository.save(new Smoothie("sweet", "medium"));
            Application.repository.save(new Smoothie("fresh", "medium"));
            List<Smoothie> actualSmoothies = Application.repository.findBySize(size);

            //then
            assertEquals(expectedSmoothies, actualSmoothies);
        }
    }