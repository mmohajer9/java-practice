package com.application.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();

        Collections.addAll(collection, "1", "2", "3");
        collection.remove("1");
        System.out.println(collection.size());

        collection.add("a");
        collection.add("b");
        collection.add("c");
        for (var item : collection) {
            System.out.println(item);
        }

        System.out.println(collection);

        var objectArray = collection.toArray();

        // you can simply pass empty array of strings (0), this method will
        // automatically create an array with enough capacity
        var stringArray = collection.toArray(new String[0]);

        System.out.println(stringArray);

        System.out.println(collection.contains("a"));

        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        var al = new ArrayList<String>();

        
        
        System.out.println(collection == other); // false
        System.out.println(collection.equals(other)); // true
    }
}
