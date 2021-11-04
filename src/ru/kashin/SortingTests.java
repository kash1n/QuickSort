package ru.kashin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

public class SortingTests {

    @Test
    @DisplayName("Sort persons")
    public void testSortPersons() {
        Person[] persons = new Person[8];
        persons[0] = new Person("Alan", "Mathison", "Turing", LocalDate.of(1912, 06, 23));
        persons[1] = new Person("Edsger", "Wybe", "Dijkstra", LocalDate.of(1930, 05, 11));
        persons[2] = new Person("Donald", "Ervin", "Knuth", LocalDate.of(1938, 01, 10));
        persons[3] = new Person("Charles", "Antony Richard", "Hoare", LocalDate.of(1934, 01, 11));
        persons[4] = new Person("Robert", "Endre", "Tarjan", LocalDate.of(1948, 04, 30));
        persons[5] = new Person("Claude", "Elwood", "Shannon", LocalDate.of(1916, 04, 30));
        persons[6] = new Person("John", "von", "Neumann", LocalDate.of(1903, 12, 28));
        persons[7] = new Person("Richard", "Manning", "Karp", LocalDate.of(1935, 01, 03));

        PersonAgeComparator comparator = new PersonAgeComparator();

        Person[] sortedWithJava = persons.clone();
        Arrays.sort(sortedWithJava, comparator);

        Person[] sortedWithQuickSort = persons.clone();
        QuickSort.Sort(sortedWithQuickSort, comparator);

        //ArrayUtils.print(sortedWithQuickSort);

        assertTrue(ArrayUtils.equals(sortedWithJava, sortedWithQuickSort, comparator));
    }

    private static class RealNumbersComparator extends CountingComparator<Double> {
        @Override
        public int internalCompare(Double t1, Double t2) {
            return t1.compareTo(t2);
        }
    }

    @Test
    @DisplayName("Sort numbers")
    public void testSortDoubles() {

        Double[] randomValues = new Double[100000];
        ArrayUtils.fillWithRandomValues(randomValues);
        RealNumbersComparator comparator = new RealNumbersComparator();

        Double[] sortedWithJava = randomValues.clone();
        Arrays.sort(sortedWithJava, comparator);

        Double[] sortedWithQuickSort = randomValues.clone();
        QuickSort.Sort(sortedWithQuickSort, comparator);

        assertArrayEquals(sortedWithJava, sortedWithQuickSort);
        //assertTrue(ArrayUtils.equals(sortedWithJava, sortedWithQuickSort));
    }

}
