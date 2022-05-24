/**
 * Abstract Building class. Holds basic Building Properties. etc,Length,heigth,position of building
 */
public abstract class Building {

    private int startPoint;
    private int endPoint;
    private int length;
    private int height;
    private int position;

    /**
     * Building default constructor
     */
    public Building() {
        this.startPoint = 0;
        this.endPoint = 0;
        this.length = 0;
        this.height = 0;
    }

    /**
     *
     * @param startPoint of Building location
     * @param length of The Building
     * @param position of the Building
     */
    public Building(int startPoint, int length, int position) {
        this.startPoint = startPoint;
        this.length = length;
        this.endPoint = startPoint + length;
        this.position = position;
    }

    /**
     *
     * @param startPoint of Building Location
     * @param length of the Building
     * @param height of the Building
     * @param position of the Building
     */
    public Building(int startPoint, int length, int height, int position) {
        this.startPoint = startPoint;
        this.length = length;
        this.endPoint = startPoint + length;
        this.height = height;
        this.position = position;
    }

    /**
     * Abstract focus method.
     */
    public abstract void focus();

    /**
     * Check if the position of the Building is valid or not.
     * @return
     */
    public boolean isInputValid(){
        return (this.startPoint >= 0 && this.length > 0 && this.height > 0 &&
                (this.position == 1 || this.position == 2));
    }

    /**
     * Overriden equals method
     * @param o Buiilding to be compared
     * @return status
     */
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Building)) {
            return false;
        }
        Building var = (Building) o;

        return (this.getStartPoint() == var.getStartPoint() &&
                this.getLength() == var.getLength() &&
                this.getHeight() == var.getHeight() &&
                this.getPosition() == var.getPosition());
    }

    /**
     * Getter for start point of Building
     * @return start point of Building
     */
    public int getStartPoint() {
        return startPoint;
    }

    /**
     * Setter for startPoint of Building
     * @param startPoint of Building
     */
    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Getter for endPOint of Building
     * @return end POint of building
     */
    public int getEndPoint() {
        return endPoint;
    }

    /**
     * Setter for endpoint of Building
     * @param endPoint of Building
     */
    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    /**
     *  Getter for length of the Building
     * @return length of the Building
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter for length of the building
     * @param length of the Building
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Getter for length of the building
     * @return length of the building
     */
    public int getHeight() {
        return height;
    }

    /**
     * setter for height of the building
     * @param height of the building
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * getter for position of the building
     * @return position of the building
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sette for position of the building
     * @param position of the building
     */
    public void setPosition(int position) {
        this.position = position;
    }
}