package io.model;
/**
 * Factory DP implementation for our Solar System of (singleton's) Planet's.
 * Using the enum PlaneName to choose which planet we want to get instance of.
 */
public abstract class PlanetFactory {
    public static Planet getPlanet(PlanetName planetName){
        Planet planet;
        switch (planetName){
            case MERCURY:
                planet = Mercury.getInstance();
                break;
            case WENUS:
                planet = Wenus.getInstance();
                break;
            case MARS:
                planet = Mars.getInstance();
                break;
            case JUPITER:
                planet = Jupiter.getInstance();
                break;
            case SATURN:
                planet = Saturn.getInstance();
                break;
            case URANUS:
                planet = Uranus.getInstance();
                break;
            case NEPTUNE:
                planet = Neptune.getInstance();
                break;
            default:
                planet = Earth.getInstance();
                break;
        }
        return planet;
    }
}
