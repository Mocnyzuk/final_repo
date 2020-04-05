package functional;

import java.util.List;

public class UserDB {

    public static List<User> usersList = List.of(
            new User("Bogdan", "Wilk", 15, "Katowice"),
            new User("Bartłomiej", "Wilk", 41, "Kraków"),
            new User("Bogdan", "Zając", 33, "Poznań"),
            new User("Zenon", "Owca", 28, "Poznań"),
            new User("Janusz", "Dudek", 51, "Kalisz"),
            new User("Sebastian", "Skowronek", 77, "Katowice"));
}
