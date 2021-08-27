package com.application.generics;

// we can set <T> based on an interface (with extends keyword).

// Comparable is an interface so we are telling that this class should always 
// get the generic type argument <T> based on a class that implements Comparable

// in here, <T> is bounded type parameter. it is restricted in here
public class ComparableGenericList<T extends Comparable & Cloneable> {
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        this.items[this.count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
