package ru.kashin;

import java.util.Random;

public class QuickSort {

    // random numbers generator
    private static final Random rng = new Random();

    public static <T> void Sort(T[] a, CountingComparator<T> cmp) {
        cmp.reset();
        sortInternal(a, 0, a.length - 1, cmp);
    }

    private static <T> void sortInternal (T[] a, int left, int right, CountingComparator<T> cmp) {
        while (right > left) {
            if (right - left < 10) {
                InsertionSort.Sort(a, left, right, cmp);
                return;
            } else {
                int i = left;
                int lt = left;
                int gt = right;

                T pivot = TukeysNinther(a, left, right, cmp);

                while (i <= gt) {
                    int cmpRes = cmp.compare(a[i], pivot);
                    if (cmpRes < 0)
                        swap(a, lt++, i++);
                    else if (cmpRes > 0)
                        swap(a, i, gt--);
                    else
                        i++;
                }

                // recursive optimisation
                if (lt - left < right - gt) {
                    sortInternal(a, left, lt - 1, cmp);
                    left = gt + 1;
                } else {
                    sortInternal(a, gt + 1, right, cmp);
                    right = lt - 1;
                }
            }
        }
    }

    // median-of-3
    private static <T> T medianOf3(T[] a, int low, int high, CountingComparator<T> cmp) {
        if (high == low + 1)
            return a[low];

        T first  = a[rng.nextInt(high + 1 - low) + low];
        T second = a[rng.nextInt(high + 1 - low) + low];
        T third  = a[rng.nextInt(high + 1 - low) + low];

        int cmp1to2 = cmp.compare(first, second);
        int cmp1to3 = cmp.compare(first, third);
        int cmp2to3 = cmp.compare(second, third);

        if ((cmp1to2 > 0) != (cmp1to3 > 0))
            return first;
        else if ((cmp1to2 < 0) != (cmp2to3 > 0))
            return second;
        else
            return third;
    }

    private static <T> T TukeysNinther (T[] a, int low, int high, CountingComparator<T> cmp) {
        T pivot1 = medianOf3(a, low, high, cmp);
        T pivot2 = medianOf3(a, low, high, cmp);
        T pivot3 = medianOf3(a, low, high, cmp);
        int cmp1to2 = cmp.compare(pivot1, pivot2);
        int cmp1to3 = cmp.compare(pivot1, pivot3);
        int cmp2to3 = cmp.compare(pivot2, pivot3);

        if ((cmp1to2 > 0) != (cmp1to3 > 0))
            return pivot1;
        else if ((cmp1to2 < 0) != (cmp2to3 > 0))
            return pivot2;
        else
            return pivot3;
    }

    private static <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
