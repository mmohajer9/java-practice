package com.application.generics;

public class List {
    private int[] items = new int[10];
    private int count;

    public void add(int item) {
        this.items[this.count++] = item;

    }

    public int get(int index) {
        return items[index];
    }
}
