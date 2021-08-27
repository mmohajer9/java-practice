package com.application.generics;

public class Instructor extends User {

    public Instructor(int points) {
        super(points);
    }

    @Override
    public String toString() {
        return "Instructor : " + super.toString();
    }

}
