
// abstract class can not be instantiated, it is only for inheritance and later instances
// its only usage is just for a common code sharing between all children instances
public abstract class Element {

    public Element(int inputArgument) {
        System.out.println("Element Constructor " + inputArgument);
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
    public abstract void render();

}
