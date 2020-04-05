package io.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanetFactoryTest {

    @Test
    @DisplayName("Should return planet of type Earth")
    void getPlanetEarth() {
        //given
        Planet givenEarth = PlanetFactory.getPlanet(PlanetName.EARTH);
        //then
        assertTrue(givenEarth instanceof Earth);
    }
    @Test
    @DisplayName("All the Earth's should be equal (singleton)")
    void earthAndEarthShouldBeEqual() {
        //given
        Earth expectedEarth = Earth.getInstance();
        //when
        Planet givenEarth = PlanetFactory.getPlanet(PlanetName.EARTH);
        //then
        assertEquals(expectedEarth, givenEarth);
    }
    @Test
    @DisplayName("Should return planet of type Mercury")
    void getPlanetMercury() {
        //given
        Planet given = PlanetFactory.getPlanet(PlanetName.MERCURY);
        //then
        assertTrue(given instanceof Mercury);
    }
    @Test
    @DisplayName("All the Mercury's should be equal (singleton)")
    void mercuryAndMercuryShouldBeEqual() {
        //given
        Mercury expected = Mercury.getInstance();
        //when
        Planet given = PlanetFactory.getPlanet(PlanetName.MERCURY);
        //then
        assertEquals(expected, given);
    }
    @Test
    @DisplayName("Should return planet of type Wenus")
    void getPlanetWenus() {
        //given
        Planet given = PlanetFactory.getPlanet(PlanetName.WENUS);
        //then
        assertTrue(given instanceof Wenus);
    }
    @Test
    @DisplayName("All the Wenuses should be equal (singleton)")
    void wenusShouldBeEqual() {
        //given
        Wenus expected = Wenus.getInstance();
        //when
        Planet given = PlanetFactory.getPlanet(PlanetName.WENUS);
        //then
        assertEquals(expected, given);
    }
    @Test
    @DisplayName("Should return planet of type Mercury")
    void getPlanetMars() {
        //given
        Planet given = PlanetFactory.getPlanet(PlanetName.MARS);
        //then
        assertTrue(given instanceof Mars);
    }
    @Test
    @DisplayName("All the Marses should be equal (singleton)")
    void marsShouldBeEqual() {
        //given
        Mars expected = Mars.getInstance();
        //when
        Planet given = PlanetFactory.getPlanet(PlanetName.MARS);
        //then
        assertEquals(expected, given);
    }
    @Test
    @DisplayName("Should return planet of type Jupiter")
    void getPlanetJupiter() {
        //given
        Planet given = PlanetFactory.getPlanet(PlanetName.JUPITER);
        //then
        assertTrue(given instanceof Jupiter);
    }
    @Test
    @DisplayName("All the Jupiter's should be equal (singleton)")
    void jupiterShouldBeEqual() {
        //given
        Jupiter expected = Jupiter.getInstance();
        //when
        Planet given = PlanetFactory.getPlanet(PlanetName.JUPITER);
        //then
        assertEquals(expected, given);
    }
    @Test
    @DisplayName("Should return planet of type Saturn")
    void getPlanetSaturn() {
        //given
        Planet given = PlanetFactory.getPlanet(PlanetName.SATURN);
        //then
        assertTrue(given instanceof Saturn);
    }
    @Test
    @DisplayName("All the Saturn's should be equal (singleton)")
    void saturnShouldBeEqual() {
        //given
        Saturn expected = Saturn.getInstance();
        //when
        Planet given = PlanetFactory.getPlanet(PlanetName.SATURN);
        //then
        assertEquals(expected, given);
    }
    @Test
    @DisplayName("Should return planet of type Uranus")
    void getPlanetUranus() {
        //given
        Planet given = PlanetFactory.getPlanet(PlanetName.URANUS);
        //then
        assertTrue(given instanceof Uranus);
    }
    @Test
    @DisplayName("All the Uranuses should be equal (singleton)")
    void uranShouldBeEqual() {
        //given
        Uranus expected = Uranus.getInstance();
        //when
        Planet given = PlanetFactory.getPlanet(PlanetName.URANUS);
        //then
        assertEquals(expected, given);
    }
    @Test
    @DisplayName("Should return planet of type Neptune")
    void getPlanetNeptune() {
        //given
        Planet given = PlanetFactory.getPlanet(PlanetName.NEPTUNE);
        //then
        assertTrue(given instanceof Neptune);
    }
    @Test
    @DisplayName("All the Neptune's should be equal (singleton)")
    void neptuneShouldBeEqual() {
        //given
        Neptune expected = Neptune.getInstance();
        //when
        Planet given = PlanetFactory.getPlanet(PlanetName.NEPTUNE);
        //then
        assertEquals(expected, given);
    }

}