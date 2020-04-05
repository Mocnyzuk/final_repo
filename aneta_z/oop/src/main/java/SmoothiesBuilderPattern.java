import java.util.Arrays;

public class SmoothiesBuilderPattern {
    private String name;
    private Base base;
    private String[] additionalIngredients;
    private int capacity;

    private SmoothiesBuilderPattern(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public Base getBase() {
        return base;
    }

    public String[] getAdditionalIngredients() {
        return additionalIngredients;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public void setAdditionalIngredients(String[] additionalIngredients) {
        this.additionalIngredients = additionalIngredients;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " smoothie" +
                ", based on " + base +
                ", with: " + Arrays.toString(additionalIngredients) +
                ", of a capacity of " + capacity +
                " ml.";
    }

    public static class SmoothiesBuilderPatternBuilder {
        private String name;
        private Base base = Base.TAP_WATER;;
        private String[] additionalIngredients = new String[]{"no additional ingredients"};
        private int capacity;

        private SmoothiesBuilderPatternBuilder(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public static SmoothiesBuilderPatternBuilder aSmoothiesBuilderPattern(String name, int capacity) {
            return new SmoothiesBuilderPatternBuilder(name, capacity);
        }

        public SmoothiesBuilderPatternBuilder withBase(Base base) {
            this.base = base;
            return this;
        }

        public SmoothiesBuilderPatternBuilder withAdditionalIngredients(String[] additionalIngredients) {
            this.additionalIngredients = additionalIngredients;
            return this;
        }

        public SmoothiesBuilderPattern build() {
            SmoothiesBuilderPattern smoothiesBuilderPattern = new SmoothiesBuilderPattern(name, capacity);
            smoothiesBuilderPattern.setBase(base);
            smoothiesBuilderPattern.setAdditionalIngredients(additionalIngredients);
            return smoothiesBuilderPattern;
        }
    }
}
