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
        double fuelNeeds = vehicle.getFuelNeeds();
        // Then
        assertEquals(7, fuelNeeds);
    }

    @Test
    @DisplayName("getDistance test")
    void getDistance() {
        // Given
        Vehicle vehicle = new Vehicle();
        // When
        double distance = vehicle.getDistance();
        // Then
        assertEquals(100, distance);
    }

    @Test
    @DisplayName("calculateFuelConsumption test")
    void calculateFuelConsumption() {
        // Given
        Vehicle vehicle = new Vehicle();
        // When
        double exptectedFuelConsumption = vehicle.getDistance() / vehicle.getFuelNeeds();
        double outcome = vehicle.calculateFuelConsumption();
        // Then
        assertEquals(exptectedFuelConsumption, outcome);
    }

}