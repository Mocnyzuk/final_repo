package pl.accenture.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    @DisplayName("getFuelNeeds test")
    void getFuelNeeds() {
        // Given
        Ship ship = new Ship();
        // When
        double fuelNeeds = ship.getFuelNeeds();
        // Then
        assertEquals(30, fuelNeeds);
    }

    @Test
    @DisplayName("getDistance test")
    void getDistance() {
        // Given
        Ship ship = new Ship();
        // When
        double distance = ship.getDistance();
        // Then
        assertEquals(300, distance);
    }
}