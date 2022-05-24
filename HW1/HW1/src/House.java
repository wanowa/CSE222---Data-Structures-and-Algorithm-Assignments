/**
 * House class extends from Building abstract class
 */
public class House extends Building{
    private int numOfRooms;
    private String color;
    private String owner;

    /**
     * Default House Constructor
     */
    public House() {
        super();
        this.numOfRooms = 0;
        this.color = "NONE";
        this.owner = "NONE";
    }

    /**
     *
     * @param startPoint of the House
     * @param length of the House
     * @param height of the House
     * @param position of the House
     * @param numOfRooms of the House
     * @param color of the House
     * @param owner of the House
     */
    public House(int startPoint, int length, int height, int position, int numOfRooms, String color, String owner) {
        super(startPoint, length, height, position);
        this.numOfRooms = numOfRooms;
        this.color = color;
        this.owner = owner;
    }

    @Override
    public void focus() {
        System.out.println("\nTHIS HOUSE'S OWNER IS "+this.owner);
    }

    /**
     * Getter for Number of the Rooms
     * @return number of the Rooms.
     */
    public int getNumOfRooms() {
        return numOfRooms;
    }

    /**
     *  Setter for Number of the Rooms
     * @param numOfRooms of the Rooms
     */
    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    /**
     * Getter for color of the House
     * @return color of the House
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for color of the House
     * @param color of the House
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter for owner of the House
     * @return owner of the House
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter for owner of the House
     * @param owner of the House
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}