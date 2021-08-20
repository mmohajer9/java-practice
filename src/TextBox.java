
public class TextBox {

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

    // method overloading
    public void setText() {
        this.setText("DUMMY");
        
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

}
