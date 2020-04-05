package functional;

import java.util.function.Predicate;

public class Predicates {

    static Predicate<User> cityIsKatowice = person -> person.getCity().equalsIgnoreCase("Katowice");
    static Predicate<User> olderThan18 = person -> (person.getAge() > 18);
}
