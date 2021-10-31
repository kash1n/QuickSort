package ru.kashin;

import java.util.Comparator;

public abstract class CountingComparator<T> implements Comparator<T> {

    private int _count = 0;
    public int count() {
        return _count;
    }
    public void reset() {
        _count = 0;
    }

    @Override
    public int compare(T t1, T t2) {
        _count++;
        return internalCompare (t1, t2);
    }

    public abstract int internalCompare(T t1, T t2);
}
