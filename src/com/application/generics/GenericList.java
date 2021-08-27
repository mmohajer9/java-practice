package com.application.generics;

// <T> represents the type of objects we want to store in this list.
// we should specify an argument or value for this parameter.
// the type of T will be cleared later when we create an instance of this class later
// when creating an instance of a generic type, we can only use a reference type
// as a generic type argument, which is <T>. If you want to use primitive types
// in <T>, you could use Wrapper Class. e.g. if you want to use <int> you can
// use its wrapper class which is Integer.
public class GenericList<T> {
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        this.items[this.count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
