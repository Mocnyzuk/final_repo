package com.domain;

import lombok.Data;

@Data
public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private int age;

    private Person() {
    }

    public static class Builder {
        private Person person = new Person();

        public Builder() {
        }

        public Builder withFirstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.person.middleName = middleName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public Builder withAge(int age) {
            this.person.age = age;
            return this;
        }

        public Builder withEmail(String email) {
            this.person.email = email;
            return this;
        }

        public Person build() {
            if (person.getFirstName() == null) {
                throw new IllegalArgumentException("Person must have name");
            }
            if (person.getAge() < 0) {
                throw new IllegalArgumentException("Age must be bigger than 0");
            }
            if (!(person.getEmail().contains("@"))) {
                throw new IllegalArgumentException("E-mail must contain @");
            }
            return person;
        }
    }
}