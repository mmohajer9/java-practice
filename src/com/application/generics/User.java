package com.application.generics;

// you can implement Generic interfaces.
// if you don't provide the generic interface with a generic type argument,
// it is going to consider <T> as Object in the methods being overriden.
public class User implements Comparable<User> {

    private int points;

    public User(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Points=" + points;
    }

    // if we did not specify the <User> in front of Comparable, the other argument
    // type will be in Object type not User type
    @Override
    public int compareTo(User other) {

        // this < 0 -> -1
        // this == 0 -> 0
        // this > 0 -> 1

        return (points < other.points ? -1 : points == other.points ? 0 : 1);
    }

}
