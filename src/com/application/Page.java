package com.application;

import com.application.interfaces.Widget;

public class Page {

    // this is called programming against interfaces
    // Widget is not a class, it's an interface
    Widget widget;

    // dependency injection and seperation of concerns with constructor injection
    public Page(Widget widget) {
        this.widget = widget;
    }

    // dependency injection and seperation of concerns with setter injection
    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    // dependency injection and seperation of concerns with method injection
    public void show(Widget widget) {
        widget.showName();
    }

    // we know that every class that implements Widget interface must have showName
    // method so we are relieved about the method existance or its signature
    public void display() {
        this.widget.showName();
    }

}
