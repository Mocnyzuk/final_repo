package pl.builder;

public class Main {

    public static void main(String[] args) {
        final Person person = new Person.Builder()
                .age(28)
                .name("name")
                .lastName("last name")
                .build();
        System.out.println(person);
    }


}
