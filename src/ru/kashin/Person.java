package ru.kashin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Person implements Comparable<Person> {
    private String firstName, secondName, lastName;
    private LocalDate birthDate;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String firstName() {
        return firstName;
    }

    public String secondName() {
        return secondName;
    }

    public String lastName() {
        return lastName;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    public Person(String firstName, String secondName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)\n", firstName, lastName, birthDate.format(dateFormatter));
    }

    @Override
    public int compareTo(Person o) {
        int cmp = lastName.compareTo(o.lastName);
        if (cmp == 0) {
            cmp = firstName.compareTo(o.firstName);
            if (cmp == 0)
                cmp = secondName.compareTo(o.secondName);
        }
        return cmp;
    }

    public static Person randomPerson () {
        Random rnd = new Random();
        int year = rnd.nextInt(122) + 1900;
        int month = rnd.nextInt(12) + 1;
        int day = rnd.nextInt(28) + 1;
        return new Person(randomName (rnd), randomName (rnd), randomSurname (rnd), LocalDate.of(year, month, day));
    }

    private static String randomName (Random rnd) {
        String[] names = {"Oliver", "Jack", "Harry", "Jacob", "Charlie",
                          "Thomas", "Oscar", "William", "James", "George",
                          "Amelia", "Olivia", "Jessica", "Emily", "Lily",
                          "Ava", "Heather", "Sophie", "Mia", "Isabella"};
        return names[rnd.nextInt(names.length)];
    }

    private static String randomSurname (Random rnd) {
        String[] names = {"Smith", "Johnson", "Williams", "Jones", "Brown",
                          "Davis", "Miller", "Wilson", "Moore", "Taylor",
                          "Anderson", "Thomas", "Jackson", "White", "Harris"};
        return names[rnd.nextInt(names.length)];
    }
}
