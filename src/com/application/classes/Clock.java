package com.application.classes;

import com.application.interfaces.Widget;

public class Clock implements Widget {

    private String name = "Clocky";


    // from Widget interface
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void showName() {
        System.out.println(name);
    }

    @Override
    public void resize(int x) {
        System.out.println("this is resize in Clock : " + x);
    }

    @Override
    public void shrink(int x) {
        System.out.println("this is shrink in Clock : " + x);
    }

    @Override
    public void getLocation() {
        System.out.println("get location in Clock");
    }

    @Override
    public void getX() {
        System.out.println("getX in Clock");
    }

    @Override
    public void getY() {
        System.out.println("getY in Clock");
    }

}
