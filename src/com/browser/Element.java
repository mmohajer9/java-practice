package com.browser;

// abstract class can not be instantiated, it is only for inheritance and later instances
// its only usage is just for a common code sharing between all children instances
public abstract class Element {

    public Element(String derivedElement) {
        System.out.println("Element Constructor of " + derivedElement);
    }

    // accesible everywhere
    public boolean isFocused = false;

    // accessible just only in the current class
    private boolean isEnabled = true;

    // accesible in children and acts as public in current package
    // you can access to this field in a child or anywhere in the current package
    protected boolean isModified = false;

    // package-private, default behaviour, acts as public in the current package
    // accesible in the current package
    boolean isHovered = false;

    // you can define final method, which prevents this method to get overriden by
    // children instances who tries to override this method
    public final void enable() {
        this.isEnabled = true;
    }

    public void disable() {
        this.isEnabled = false;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    // we can also have abstract method. This will force the children classes to
    // implement render methods in their definition. Otherwise it is not necessary
    // if you remove the abstract keyword from it.
    
    // there is another reason that we add render as an abstract method
    // we can also add render to the children without specifying it as an abstract
    // method in the parent class which is Element. However, if we do this when we
    // want to use polymorphism and store the children in the Element variable and
    // container, we can not access to the shared method like render then we should
    // down cast the Element to the appropriate class.
    public abstract void render();

}
