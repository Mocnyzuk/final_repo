import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmoothiesTest {

    @Test
    void buildLactoseFreeSmoothie() {
        //given
        String name = "LactoseFree";
        Integer capacity = 330;
        Base base = Base.lACTOSE_FREE_MILK;
        String[] additionalIngredients = {"no additional ingredients"};

        SmoothiesBuilderPattern expectedLactoseFree330Smoothie = SmoothiesBuilderPattern
                .SmoothiesBuilderPatternBuilder
                .aSmoothiesBuilderPattern(name, capacity)
                .withBase(base)
                .build();
        //when
        SmoothiesBuilderPattern actualSmoothie = Smoothies.build330LactoseFreeSmoothie();

        //then
        assertEquals(expectedLactoseFree330Smoothie.toString(), actualSmoothie.toString());
        assertTrue(actualSmoothie.toString().contains("LactoseFree smoothie, based on lACTOSE_FREE_MILK, with: [no additional ingredients], of a capacity of 330 ml."));
    }

    @Test
    void buildSweetSmoothie() {
        //given
        String name = "Sweet";
        Integer capacity = 750;
        String[] additionalIngredients = new String[]{"strawberry", "raspberry", "banana"};

        SmoothiesBuilderPattern expected750SweetSmoothie = SmoothiesBuilderPattern
                .SmoothiesBuilderPatternBuilder
                .aSmoothiesBuilderPattern(name, capacity)
                .withAdditionalIngredients(additionalIngredients)
                .build();
        //when
        SmoothiesBuilderPattern actualSmoothie = Smoothies.build750SweetSmoothie();

        //then
        assertEquals(expected750SweetSmoothie.toString(), actualSmoothie.toString());
        assertTrue(actualSmoothie.toString().contains("Sweet smoothie, based on TAP_WATER, with: [strawberry, raspberry, banana], of a capacity of 750 ml."));
    }

    @Test
    void buildFreshSmoothie() {
        //given
        String name = "Fresh";
        Integer capacity = 330;
        String[] additionalIngredients = {"no additional ingredients"};

        SmoothiesBuilderPattern expected750SweetSmoothie = SmoothiesBuilderPattern
                .SmoothiesBuilderPatternBuilder
                .aSmoothiesBuilderPattern(name, capacity)
                .build();
        //when
        SmoothiesBuilderPattern actualSmoothie = Smoothies.build330FreshSmoothie();

        //then
        assertEquals(expected750SweetSmoothie.toString(), actualSmoothie.toString());
        assertTrue(actualSmoothie.toString().contains("Fresh smoothie, based on TAP_WATER, with: [no additional ingredients], of a capacity of 330 ml."));
    }
}