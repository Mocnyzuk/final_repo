package functional;

import lombok.var;

import java.util.List;
import java.util.stream.Collectors;

import static functional.UserDB.usersList;

public class UsersLists {

    /**
     * @return List of users sorted by name
     **/
    public static List<User> usersSortedByName() {

        List<User> usersListSortedByName = usersList
                .stream()
                .sorted(Comparators.sortByName)
                .collect(Collectors.toList());

        return usersListSortedByName;
    }

    /**
     * @return List of "usersList" sorted by last name and then by name
     */
    public static List<User> usersSortedByLastNameAndThenByName() {


        List<User> usersListSortedByLastNameAndThenByName = usersList
                .stream()
                .sorted(Comparators.sortByLastName.thenComparing(Comparators.sortByName))
                .collect(Collectors.toList());

        return usersListSortedByLastNameAndThenByName;
    }

    /**
     * @return List of users who are from Katowice
     **/
    public static List<User> usersWhoseCityIsKatowice() {

        List<User> collectFilterCityIsKatowice = usersList
                .stream()
                .filter(Predicates.cityIsKatowice)
                .collect(Collectors.toList());

        return collectFilterCityIsKatowice;
    }

    /**
     * @return List of users who are over 18
     **/
    public static List<User> usersWhoAreOver18() {

        List<User> collectFilterOlderThan18 = usersList
                .stream()
                .filter(Predicates.olderThan18)
                .collect(Collectors.toList());

        return collectFilterOlderThan18;
    }
}
