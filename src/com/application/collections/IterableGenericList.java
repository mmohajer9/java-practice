package com.application.collections;

import java.util.Iterator;

import com.application.generics.GenericList;

public class IterableGenericList<T> extends GenericList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
