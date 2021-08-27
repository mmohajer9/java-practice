package com.application.generics;

// T can only be the Number class or the child classes of Number
public class NumericalGenericList<T extends Number> {
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        this.items[this.count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
