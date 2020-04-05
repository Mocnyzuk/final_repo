package pl.accenture.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.accenture.oop.factoryPattern.elements.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    @DisplayName("Should return 7")
    void getFuelNeeds() {
        // Given
        Vehicle vehicle = new Vehicle();
        // When
        double fuelNeeds = vehicle.getFuelNeeds();
        // Then
        assertEquals(7, fuelNeeds);
    }

    @Test
    @DisplayName("Should return 100")
    void getDistance() {
        // Given
        Vehicle vehicle = new Vehicle();
        // When
        double distance = vehicle.getDistance();
        // Then
        assertEquals(100, distance);
    }

    @Test
    @DisplayName("For distance = 100, fuelNeeds = 5 should return 20")
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