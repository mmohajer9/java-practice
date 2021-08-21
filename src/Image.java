public class Image extends Element implements Draggable {

    public Image(int inputArgument) {
        super("Image");
    }

    // from Element abstract class
    @Override
    public void render() {
        System.out.println("Image render");
    }

    // from Draggable interface
    @Override
    public void getLocation() {
        System.out.println("get location in Image");
    }

    @Override
    public void getX() {
        System.out.println("getX in Image");
    }

    @Override
    public void getY() {
        System.out.println("getY in Image");
    }

}
