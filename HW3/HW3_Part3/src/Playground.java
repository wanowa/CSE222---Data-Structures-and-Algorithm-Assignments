/**
 * PlayGround class extends from Abstarct Building class
 */

public class Playground extends Building{
    /**
     * Default Constructor
     */
    public Playground(){
        super();
        this.setHeight(2);
    }

    /**
     *
     * @param startPoint of Play Ground
     * @param length of Play Ground
     * @param position of Play Ground
     */
    public Playground(int startPoint, int length, int position) {
        super(startPoint, length, position);
        this.setHeight(2);
    }

    @Override
    // Printing the length of the playground.
    public void focus() {
        System.out.println("\nTHIS PLAYGROUND'S LENGTH IS "+this.getLength());
    }

}
