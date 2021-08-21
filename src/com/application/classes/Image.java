package com.application.classes;

import com.application.interfaces.Draggable;

public class Image implements Draggable {

    // from Draggable interface
    @Override
    public void getLocation() {
        System.out.println("get location in Image");
    }

    @Override
    public void getX() {
        System.out.println("getX in Image");
    }

    @Override
    public void getY() {
        System.out.println("getY in Image");
    }

}
