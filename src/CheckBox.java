
// we can have final classes, which means that you can not extend the class but you can instantiate it.
// just like the opposite of abstract classes which operates on the contrary to the final classes
public final class CheckBox extends Element {

    public CheckBox() {
        super(123);
    }

    // we should override or implement render method because it is an abstract
    // method in the parent class
    @Override
    public void render() {
        System.out.println("CheckBox render");
    }

    // will throw an error because we are trying to override a final method
    // @Override
    // public void enable(){
    // ...
    // }
}
