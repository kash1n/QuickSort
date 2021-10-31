package ru.kashin;

public class ArrayUtils {
    public static <T> void print (T[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i].toString());
            if (i < N - 1)
                System.out.print(", ");
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

    public static void fillWithRandomValues(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
        }
    }
}
