package com.application;

import com.application.interfaces.Widget;

public class Page {

    Widget widget;

    public Page(Widget widget) {
        this.widget = widget;
    }

    public void display() {
        widget.showName();
    }

}
