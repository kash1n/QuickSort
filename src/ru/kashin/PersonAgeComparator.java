package ru.kashin;

public class PersonAgeComparator extends CountingComparator<Person> {
    @Override
    public int internalCompare(Person t1, Person t2) {
        return t1.birthDate().compareTo(t2.birthDate());
    }
}
