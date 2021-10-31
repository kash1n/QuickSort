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
        return String.format("%s, %s %s (%s)\n", lastName, firstName, secondName, birthDate.format(dateFormatter));
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
        int year = rnd.nextInt(2021) + 1;
        int month = rnd.nextInt(12) + 1;
        int day = rnd.nextInt(28) + 1;
        return new Person(randomString (), randomString (), randomString (), LocalDate.of(year, month, day));
    }

    private static String randomString () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        int targetStringLength = random.nextInt(10) + 3;

        return random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
    }
}
