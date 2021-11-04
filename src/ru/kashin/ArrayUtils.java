package ru.kashin;

public class ArrayUtils {
    private static final int MAX_SIZE_FOR_PRINT = 10;

    public static <T> void print (T[] arr) {
        if (arr.length <= MAX_SIZE_FOR_PRINT) {
            for (T t : arr) {
                System.out.print(" " + t.toString());
            }
        } else {
            for (int i = 0; i < 4; i++)
                System.out.print(" " + arr[i].toString());
            System.out.println(" ...");
            for (int i = arr.length - 4; i < arr.length; i++)
                System.out.print(" " + arr[i].toString());
        }
        System.out.println ();
    }
    public static <T> void print (T[] arr, String caption) {
        if (caption.length() > 0)
            System.out.println(caption + ":");
        print(arr);
    }

    public static <T extends Comparable<T>> boolean equals (T[] arr1, T[] arr2) {
        int N = arr1.length;
        if (N != arr2.length)
            return false;
        for (int i = 0; i < N; i++) {
            if (arr1[i].compareTo(arr2[i]) != 0)
                return false;
        }
        return true;
    }

    public static <T> boolean equals (T[] arr1, T[] arr2, CountingComparator<T> cmp) {
        int N = arr1.length;
        if (N != arr2.length)
            return false;
        for (int i = 0; i < N; i++) {
            if (cmp.compare(arr1[i], arr2[i]) != 0)
                return false;
        }
        return true;
    }

    public static void fillWithRandomValues(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
        }
    }

    public static void fillWithRandomValues(Person[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            a[i] = Person.randomPerson();
        }
    }
}
