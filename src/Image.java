public class Image extends Element implements Draggable {

    public Image(int inputArgument) {
        super("Image");
    }

    @Override
    public void render() {
        System.out.println("Image render");
    }

}
