public class Playground extends Building{

    public Playground(){
        super();
        this.setHeight(2);
    }

    public Playground(int startPoint, int length, int position) {
        super(startPoint, length, position);
        this.setHeight(2);
    }

    @Override
    public void focus() {
        System.out.println("\nTHIS PLAYGROUND'S LENGTH IS "+this.getLength());
    }

}
