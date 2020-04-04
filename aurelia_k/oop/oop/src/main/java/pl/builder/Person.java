package pl.builder;


public class Person {
    private String name;
    private String lastName;
    private int age;
    private boolean isHappy;
    private boolean working;

    private Person() {
    }

    public static final class Builder {
        private String name;
        private String lastName;
        private int age;
        private boolean isHappy;
        private boolean working;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder isHappy(boolean happy) {
            isHappy = happy;
            return this;
        }

        public Builder isWorking(boolean working) {
            this.working = working;
            return this;
        }

        public Person build() {

            Person person = new Person();
            person.name = this.name;
            person.lastName = this.lastName;
            person.age = this.age;
            person.working = this.working;
            person.isHappy = this.isHappy;
            return person;
        }


    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isHappy=" + isHappy +
                ", working=" + working +
                '}';
    }
}

