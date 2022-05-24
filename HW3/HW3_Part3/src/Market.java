/**
 * Market class extended from Abstarct Building Class
 */
public class Market extends Building{
    private String openingTime;
    private String closingTime;
    private String owner;

    /**
     * Default market Constructor
     */
    public Market(){
        super();
        this.openingTime = "NONE";
        this.closingTime = "NONE";
        this.owner = "NONE";
    }

    /**
     *
     * @param startPoint of the Market
     * @param length of the Market
     * @param height of the Market
     * @param position of the Market
     * @param openingTime of the Market
     * @param closingTime of the Market
     * @param owner of the Market
     */
    public Market(int startPoint, int length, int height, int position, String openingTime, String closingTime, String owner) {
        super(startPoint, length, height, position);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.owner = owner;
    }

    /**
     * This method prints out the closing time of the market
     */
    @Override
    public void focus() {
        System.out.println("\nTHIS MARKET'S CLOSING TIME IS "+this.closingTime);
    }

    /**
     * Getter for Openinig time
     * @return Openinig time
     */
    public String getOpeningTime() {
        return openingTime;
    }

    /**
     * Setter for Openinig time
     * @param openingTime of Market
     */
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    /**
     * Getter for Closing Time
     * @return Closing Time
     */
    public String getClosingTime() {
        return closingTime;
    }

    /**
     * Setter for Closing Time
     * @param closingTime Closing Time of Market
     */
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    /**
     * Getter for owner of the market
     * @return owner of the market
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter for owner of the market
     * @param owner of the Market
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
