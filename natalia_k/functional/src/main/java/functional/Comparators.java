package functional;

import java.util.Comparator;

public class Comparators {

    static Comparator<User> sortByLastName = Comparator.comparing(User::getLastName);
    static Comparator<User> sortByName = Comparator.comparing(User::getName);

}
