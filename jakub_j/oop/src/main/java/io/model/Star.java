package io.model;

public class Star {
    private long radius;
    private StarBrightness brightness;
    private String name;


    private Star(String name) {
        this.name = name;
    }

    public long getRadius() {
        return radius;
    }

    public void setRadius(long radius) {
        this.radius = radius;
    }

    public StarBrightness getBrightness() {
        return brightness;
    }

    public void setBrightness(StarBrightness brightness) {
        this.brightness = brightness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class StarBuilder {
        private long radius;
        private StarBrightness brightness;
        private String name;

        private StarBuilder(String name) {
            this.name = name;
        }

        public static StarBuilder aStar(String name) {
            return new StarBuilder(name);
        }

        public StarBuilder withRadius(long radius) {
            this.radius = radius;
            return this;
        }

        public StarBuilder withBrightness(StarBrightness brightness) {
            this.brightness = brightness;
            return this;
        }

        public Star build() {
            Star star = new Star(name);
            star.setRadius(radius);
            star.setBrightness(brightness);
            return star;
        }
    }
}
