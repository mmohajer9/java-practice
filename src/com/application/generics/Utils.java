package com.application.generics;

public class Utils {

    // generic method - we did not apply the generic type argument to the whole
    // Utils class. we only needed that in this method.
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? first : second;
    }
}
