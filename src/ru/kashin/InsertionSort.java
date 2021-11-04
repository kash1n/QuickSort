package ru.kashin;

public class InsertionSort {

    public static <T> void Sort(T[] a, CountingComparator<T> cmp) {
        cmp.reset();
        Sort(a, 0, a.length - 1, cmp);
    }

    public static <T> void Sort(T[] a, int left, int right, CountingComparator<T> cmp) {
        for (int i = left + 1; i <= right; i++) {
            T value = a[i];
            int j = i - 1;
            while (j >= left && cmp.compare(a[j], value) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = value;
        }
    }
}
