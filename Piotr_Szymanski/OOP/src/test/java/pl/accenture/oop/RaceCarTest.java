package pl.accenture.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceCarTest {

    @Test
    @DisplayName("getFuelNeeds test")
    void getFuelNeeds() {
        // Given
        RaceCar raceCar = new RaceCar();
        // When
        double fuelNeeds = raceCar.getFuelNeeds();
        // Then
        assertEquals(70, fuelNeeds);

    }
}