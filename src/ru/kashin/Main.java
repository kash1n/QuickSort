package ru.kashin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final int arraySize = 1000000;
        Person[] a, b, randomValues = new Person[arraySize];
        ArrayUtils.fillWithRandomValues(randomValues);
        PersonAgeComparator comparator = new PersonAgeComparator();
        long timerStart, timerFinish, elapsed;

        // sort with function from Java
        a = randomValues.clone();
        timerStart = System.currentTimeMillis();
        Arrays.sort(a, comparator);
        timerFinish = System.currentTimeMillis();
        elapsed = timerFinish - timerStart;
        ArrayUtils.print(a, "Sorted by Java");
        System.out.println("Elapsed: " + elapsed / 1000.);
        System.out.println("Comparisons: " + comparator.count());
        System.out.println();
        comparator.reset();

        // sort with QuickSort
        b = randomValues.clone();
        timerStart = System.currentTimeMillis();
        QuickSort.Sort(b, comparator);
        timerFinish = System.currentTimeMillis();
        elapsed = timerFinish - timerStart;
        ArrayUtils.print(b, "Sorted by QuickSort");
        System.out.println("Elapsed: " + elapsed / 1000.);
        System.out.println("Comparisons: " + comparator.count());
        System.out.println();
        comparator.reset();

        boolean ok = ArrayUtils.equals (a, b, comparator);
        System.out.println(ok ? "OK" : "FAIL");
    }
}
