package ru.kashin;

import java.util.Arrays;

public class Main {

    private static class RealNumbersComparator extends CountingComparator<Double> {
        @Override
        public int internalCompare(Double t1, Double t2) {
            return t1.compareTo(t2);
        }
    }

    public static void main(String[] args) {

        final int arraySize = 100000;
        Person[] a, b, randomValues = new Person[arraySize];
        ArrayUtils.fillWithRandomValues(randomValues);
        PersonAgeComparator comparator = new PersonAgeComparator();

//        Person[] persons = new Person[8];
//        persons[0] = new Person("Alan", "Mathison", "Turing", LocalDate.of(1912, 06, 23));
//        persons[1] = new Person("Edsger", "Wybe", "Dijkstra", LocalDate.of(1930, 05, 11));
//        persons[2] = new Person("Donald", "Ervin", "Knuth", LocalDate.of(1938, 01, 10));
//        persons[3] = new Person("Charles", "Antony Richard", "Hoare", LocalDate.of(1934, 01, 11));
//        persons[4] = new Person("Robert", "Endre", "Tarjan", LocalDate.of(1948, 04, 30));
//        persons[5] = new Person("Claude", "Elwood", "Shannon", LocalDate.of(1916, 04, 30));
//        persons[6] = new Person("John", "von", "Neumann", LocalDate.of(1903, 12, 28));
//        persons[7] = new Person("Richard", "Manning", "Karp", LocalDate.of(1935, 01, 03));

        // sort with function from Java
        a = randomValues.clone();
        Arrays.sort(a, comparator);
        ArrayUtils.print(a, "Sorted by Java");
        System.out.println("Comparisons: " + comparator.count());
        System.out.println();
        comparator.reset();

        // sort with QuickSort
        b = randomValues.clone();
        QuickSort.Sort(b, comparator);
        ArrayUtils.print(b, "Sorted by QuickSort");
        System.out.println("Comparisons: " + comparator.count());
        System.out.println();
        comparator.reset();

        boolean ok = ArrayUtils.equals (a, b, comparator);
        System.out.println("Comparisons (check): " + comparator.count());
        System.out.println(ok ? "OK" : "FAIL");
        System.out.println("N*log(N) = " + Math.round (arraySize * Math.log(arraySize) / Math.log(2)));
    }
}
