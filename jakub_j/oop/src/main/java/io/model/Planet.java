package io.model;

/**
 * Interface with we implement on all the singleton's Planet since its
 * the example of reality.
 */
public interface Planet {
    String tellSomethingAboutYou();
    boolean hasResidents();

    String showYourself = "I'm %s, planet number: %d in our Solar System.";
}
