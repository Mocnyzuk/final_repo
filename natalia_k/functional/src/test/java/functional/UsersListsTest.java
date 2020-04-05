package functional;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UsersListsTest {

    @Test
    @DisplayName("usersList ->  list sorted by name")
    void usersSortedByName() {
        List<User> expectedList = List.of(

                new User("Bartłomiej", "Wilk", 41, "Kraków"),
                new User("Bogdan", "Wilk", 15, "Katowice"),
                new User("Bogdan", "Zając", 33, "Poznań"),
                new User("Janusz", "Dudek", 51, "Kalisz"),
                new User("Sebastian", "Skowronek", 77, "Katowice"),
                new User("Zenon", "Owca", 28, "Poznań")
        );

        assertEquals(expectedList, UsersLists.usersSortedByName());
    }

    @Test
    @DisplayName("usersList ->  list sorted by last name and then by name")
    void usersSortedByLastNameAndThenByName() {
        List<User> expectedList = List.of(
                new User("Janusz", "Dudek", 51, "Kalisz"),
                new User("Zenon", "Owca", 28, "Poznań"),
                new User("Sebastian", "Skowronek", 77, "Katowice"),
                new User("Bartłomiej", "Wilk", 41, "Kraków"),
                new User("Bogdan", "Wilk", 15, "Katowice"),
                new User("Bogdan", "Zając", 33, "Poznań")
        );

        assertEquals(expectedList, UsersLists.usersSortedByLastNameAndThenByName());
    }


    @Test
    @DisplayName("usersList ->  list of users who are from Katowice")
    void usersWhoseCityIsKatowice() {

        List<User> expectedList = List.of(
                new User("Bogdan", "Wilk", 15, "Katowice"),
                new User("Sebastian", "Skowronek", 77, "Katowice")

        );

        assertEquals(expectedList, UsersLists.usersWhoseCityIsKatowice());
    }

    @Test
    @DisplayName("usersList ->  list of users who are over 18")
    void usersWhoAreOver18() {

        List<User> expectedList = List.of(
                new User("Bartłomiej", "Wilk", 41, "Kraków"),
                new User("Bogdan", "Zając", 33, "Poznań"),
                new User("Zenon", "Owca", 28, "Poznań"),
                new User("Janusz", "Dudek", 51, "Kalisz"),
                new User("Sebastian", "Skowronek", 77, "Katowice")

        );

        assertEquals(expectedList, UsersLists.usersWhoAreOver18());
    }
}