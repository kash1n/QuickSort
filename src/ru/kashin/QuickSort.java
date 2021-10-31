package ru.kashin;

public class QuickSort {

    public static <T> void Sort(T[] a, CountingComparator<T> cmp)
    {
        int N = a.length;
        sortInternal(a, 0, N-1, cmp);
    }

    private static <T> void sortInternal (T[] a, int left, int right,
                                          CountingComparator<T> cmp) {
        if (left >= right)
            return;
        int partitionIndex = partition(a, left, right, cmp);
        if (partitionIndex < a.length / 2) {
            sortInternal(a, left, partitionIndex-1, cmp);
            sortInternal(a, partitionIndex+1, right, cmp);
        }
        else {
            sortInternal(a, partitionIndex+1, right, cmp);
            sortInternal(a, left, partitionIndex-1, cmp);
        }
    }

    private static <T> int partition (T[] a, int left, int right,
                                      CountingComparator<T> cmp) {
        T pivot = a[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (cmp.compare(a[j], pivot) <= 0) {
                i++;
                T tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        T tmp = a[i + 1];
        a[i + 1] = a[right];
        a[right] = tmp;
        return i + 1;
    }
}
