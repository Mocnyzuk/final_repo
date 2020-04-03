package pl.accenture.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    @DisplayName("getFuelNeeds test")
    void getFuelNeeds() {
        // Given
        Plane plane = new Plane();
        // When
        double fuelNeeds = plane.getFuelNeeds();
        // Then
        assertEquals(100, fuelNeeds);


    }

    @Test
    @DisplayName("getDistance test")
    void getDistance() {

    }
}