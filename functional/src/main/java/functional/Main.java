package functional;

public class Main {
    public static void main(String[] args) {

        UsersLists usersLists = new UsersLists();

        System.out.println("Lista użytkowników posortowana według  imienia");
        System.out.println(usersLists.usersSortedByName());
        System.out.println("=============================================================");
        System.out.println("Lista użytkowników posortowana według nazwiska, potem według imienia");
        System.out.println(usersLists.usersSortedByLastNameAndThenByName());
        System.out.println("=============================================================");
        System.out.println("Lista użytkowników, którzy mają powyżej 18 lat");
        System.out.println(usersLists.usersWhoAreOver18());
        System.out.println("=============================================================");
        System.out.println("Lista użytkowników, których miasto to Katowice");
        System.out.println(usersLists.usersWhoseCityIsKatowice());
    }
}
