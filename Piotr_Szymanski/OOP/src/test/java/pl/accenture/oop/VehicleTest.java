package pl.accenture.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    @DisplayName("getFuelNeeds test")
    void getFuelNeeds() {
        // Given
        Vehicle vehicle = new Vehicle();
        // When
        // Then
        assertEquals(7, vehicle.getFuelNeeds());
    }

    @Test
    @DisplayName("getDistance test")
    void getDistance() {
        // Given
        Vehicle vehicle = new Vehicle();
        // When
        // Then
        assertEquals(100, vehicle.getDistance());
    }

    @Test
    @DisplayName("calculateFuelConsumption test")
    void calculateFuelConsumption() {
    }

}