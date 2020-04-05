package pl.accenture.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.accenture.oop.factoryPattern.elements.Plane;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    @DisplayName("Should return 100")
    void getFuelNeeds() {
        // Given
        Plane plane = new Plane();
        // When
        double fuelNeeds = plane.getFuelNeeds();
        // Then
        assertEquals(100, fuelNeeds);
    }

    @Test
    @DisplayName("Should return 100")
    void getDistance() {
        // Given
        Plane plane = new Plane();
        // When
        double distance = plane.getFuelNeeds();
        // Then
        assertEquals(100, distance);
    }

}