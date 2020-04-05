public class Smoothies {
    static SmoothiesBuilderPattern build330LactoseFreeSmoothie() {
        return SmoothiesBuilderPattern
                .SmoothiesBuilderPatternBuilder
                .aSmoothiesBuilderPattern("LactoseFree", 330)
                .withBase(Base.lACTOSE_FREE_MILK)
                .build();
    }

    static SmoothiesBuilderPattern build750SweetSmoothie() {
        return SmoothiesBuilderPattern
                .SmoothiesBuilderPatternBuilder
                .aSmoothiesBuilderPattern("Sweet", 750)
                .withAdditionalIngredients(new String[]{"strawberry", "raspberry", "banana"})
                .build();
    }

    static SmoothiesBuilderPattern build330FreshSmoothie() {
        return SmoothiesBuilderPattern
                .SmoothiesBuilderPatternBuilder
                .aSmoothiesBuilderPattern("Fresh", 330)
                .build();
    }
}
