package com.browser;
// using inheritance by using "extends" keyword
// every class that we declare, directly or indirectly inherits from the Object class
// which is the built-in Object built by Java

public class TextBox extends Element {

    // by default if we don't initialize reference types, they will get null as an
    // initial value, just like undefined in javascript
    public String text;

    // avoid having null with giving initial value to the field
    private String safeText = "";

    // we can access to static members from non-static context. But it is not true
    // for the reverse situation, which means we can not access to non-static
    // members from static context. BE CAREFUL !
    public static int numberOfBoxes;

    // constructor
    public TextBox(String text, String safeText) {

        // with "super" keyword we can pass the arguments to the parent constructor
        // parameters. just like "this" key word which we could access to current object
        // and constructors.
        super("TextBox");

        System.out.println("TextBox Constructor");

        this.text = text;
        this.safeText = safeText;

        // we can access to static members from non-static context
        // TextBox.numberOfBoxes or numberOfBoxes
        numberOfBoxes++;
    }

    // copy constructor
    public TextBox() {
        // with this() we can call the actual first constructor and so on
        this("", "");
    }

    // @annotation is basically a label that we attach to a class member. And with
    // this we get extra information to the java compiler, hence java compiler can
    // check the signature of this method and make sure that this method has the
    // same exact signature with the parent method

    @Override
    public String toString() {

        return this.text;
    }

    // method overloading
    public void setText() {
        this.setText("DUMMY");
        this.setSafeText("DUMMY");
    }

    public void setText(String text) {
        this.text = text;
    }

    // some useful methods
    public void clear() {
        this.text = "";
    }

    // getter
    public String getSafeText() {
        return safeText;
    }

    // setter
    public void setSafeText(String safeText) {
        this.safeText = safeText;
    }

    @Override
    public void render() {

        System.out.println("TextBox render");
    }

}
