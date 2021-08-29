package com.application.collections;

import java.util.Iterator;

public class IterableGenericList<T> implements Iterable<T> {

    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        this.items[this.count++] = item;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {

        private IterableGenericList<T> list;
        private int index;

        public ListIterator(IterableGenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {

            // we can also use "count" instead of accessing the list variable, but this is
            // not correct approach, because in the current format, this private class is
            // only coupled via list variable through its constructor to the outside class
            // and with using "count" instead of "list.count", we are increasing the
            // coupling points and it's a bad pattern.
            return (index < list.count);
        }

        @Override
        public T next() {

            // the details I wrote down for hasNext() is also true for this method, since
            // we'd better not use "items" instead of "list.items".
            return list.items[index++];
        }

    }

}
