package com.application.classes;

import com.application.interfaces.Widget;

public class Workspace implements Widget {

    private String name = "WS";


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
        System.out.println("this is resize in Workspace : " + x);
    }

    @Override
    public void shrink(int x) {
        System.out.println("this is shrink in Workspace : " + x);
    }

    @Override
    public void getLocation() {
        System.out.println("get location in Workspace");
    }

    @Override
    public void getX() {
        System.out.println("getX in Workspace");
    }

    @Override
    public void getY() {
        System.out.println("getY in Workspace");
    }

}
