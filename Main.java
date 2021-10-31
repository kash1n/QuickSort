package ru.kashin;

import java.util.Arrays;

public class Main {

    public static class RealNumbersComparator extends CountingComparator<Double> {

        @Override
        public int internalCompare(Double t1, Double t2) {
            return t1.compareTo(t2);
        }
    }

    public static void main(String[] args) {

        RealNumbersComparator dblCmp = new RealNumbersComparator();
        Double[] randomValues = new Double[10];
        ArrayUtils.fillWithRandomValues(randomValues);

        // sort with function from Java
        Double[] a;
        a = randomValues.clone();
        Arrays.sort(a, dblCmp);
        ArrayUtils.print(a, "Sorted by Java");
        System.out.println("Comparisons: " + dblCmp.count());

        // sort with QuickSort
        Double[] b;
        b = randomValues.clone();
        dblCmp.reset();
        QuickSort.Sort(b, dblCmp);
        ArrayUtils.print(b, "Sorted by QuickSort");
        System.out.println("Comparisons: " + dblCmp.count());

        boolean ok = ArrayUtils.equals (a, b);
        System.out.println(ok ? "OK" : "FAIL");
    }
}
