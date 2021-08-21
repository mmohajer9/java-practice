package com.application.classes;

import com.application.interfaces.Draggable;
import com.application.interfaces.Resizable;

public class Navbar implements Draggable, Resizable {

    @Override
    public void resize(int x) {
        System.out.println("this is resize in Navbar : " + x);
    }

    @Override
    public void shrink(int x) {
        System.out.println("this is resize in Navbar : " + x);
    }

    @Override
    public void getLocation() {
        System.out.println("this is resize in Navbar");
    }

    @Override
    public void getX() {
        System.out.println("this is resize in Navbar");
    }

    @Override
    public void getY() {
        System.out.println("this is resize in Navbar");
    }

}
