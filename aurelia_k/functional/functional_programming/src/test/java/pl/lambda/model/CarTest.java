package pl.lambda.model;

import io.github.netmikey.logunit.api.LogCapturer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.ArrayList;
import java.util.List;

class CarTest {
    @RegisterExtension
    LogCapturer logs = LogCapturer.create().captureForType(Car.class);

    @Test
    @DisplayName("car.start() -> Car starting...")
    void start() {
        //given
        Car car = new Car();
        //when
        car.start();
        //then
        logs.assertContains("Car starting...");

    }

    @Test
    @DisplayName("car.createCars() ->Car(owner=Owner(name=Jan, lastName=Kowalski), dateOfProduction=2009), Car(owner=Owner(name=Jan, lastName=Katk), dateOfProduction=2009)...  ")
    void createCars() {
        //given
        Car car = new Car();
        List<Car> expectedListCar = new ArrayList<>();
        final List<Owner> owners = List.of(
                new Owner("Jan", "Kowalski"),
                new Owner("Jan", "Badaj"),
                new Owner("Jan", "Katk"),
                new Owner("Jan", "Jdbsa"),
                new Owner("Jan", "Ojkda")
        );
        for (int i = 0; i < 3; i++) {
            expectedListCar.add(new Car(owners.get(i), 2009));
            expectedListCar.add(new Car(owners.get(i), 1999));
        }
        //when
        List<Car> result = car.createCars();
        //then
        assertEquals(expectedListCar, result);
    }
}