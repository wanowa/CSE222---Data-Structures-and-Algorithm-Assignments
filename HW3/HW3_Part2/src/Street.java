import java.util.*;

public class Street {
    private int streetLength;       //Length of the street
    private static final int initialCapacity = 10;  //Initial capacity of building array
    private LinkedList<Building> rightBuildings;  //Building array of the buildings on the right
    private LinkedList<Building> leftBuildings;   //Building array of the buildings on the right
    private int right;
    public Street(){        //My default constructor. I initialize my fields.
        this.rightBuildings = new LinkedList<>();
        this.leftBuildings = new LinkedList<>();
        this.streetLength = 0;
    }

    public Street(int streetLength) {
        this.streetLength = streetLength;
        this.rightBuildings = new LinkedList<>();
        this.leftBuildings = new LinkedList<>();
    }

    /**
     * Prints some information about the building
     *
     * @param side 1 for left side, 2 for right side
     * @param index The index of the building in the list of buildings.
     */
    public void printBuildingInformation(int side, int index){
        if(side == 1){                          //Prints some Informations
            leftBuildings.get(index).focus();              //about building
        }
        else{
            rightBuildings.get(index).focus();
        }
    }

    /**
     * Returns the building to the right of the building at the given index
     *
     * @param index The index of the building you want to get.
     * @return The building at the given index.
     */
    public Building getRightBuilding(int index){
        return this.rightBuildings.get(index);
    }

    /**
     * Returns the building to the left of the building at the given index
     *
     * @param index The index of the building you want to get.
     * @return The building at the specified index in the leftBuildings array.
     */
    public Building getLeftBuilding(int index){
        return this.leftBuildings.get(index);
    }

    /**
     * This function checks if two buildings are conflict. If so, returns true, otherwise return false
     *
     * @param b the building that you want to check for conflicts.
     * @return The method returns true if there is a conflict, otherwise returns false.
     */
    public boolean isConflict(Building b){  //This method checks if two building is conflict. If so, returns true, otherwise return false.
        if(b.getPosition() == 1){       //If getPosition() == 1 --> Buildings are on the left
            for (Building leftBuilding : this.leftBuildings) {
                if ((leftBuilding.getStartPoint() > b.getStartPoint() &&    //I checked all situations that buildings are conflict.
                        leftBuilding.getStartPoint() < b.getEndPoint()) ||
                        (leftBuilding.getEndPoint() > b.getStartPoint() &&
                                leftBuilding.getEndPoint() < b.getEndPoint()) ||
                        (leftBuilding.getStartPoint() < b.getStartPoint() &&
                                leftBuilding.getEndPoint() > b.getEndPoint()) ||
                        (leftBuilding.getStartPoint() > b.getStartPoint() &&
                                leftBuilding.getEndPoint() < b.getEndPoint())) {
                    return true;
                }
            }
        }
        else{       //Else --> Buildings are on the left
            for (Building rightBuilding : this.rightBuildings) {
                if ((rightBuilding.getStartPoint() > b.getStartPoint() &&   //I checked all situations that buildings are conflict.
                        rightBuilding.getStartPoint() < b.getEndPoint()) ||
                        (rightBuilding.getEndPoint() > b.getStartPoint() &&
                                rightBuilding.getEndPoint() < b.getEndPoint()) ||
                        (rightBuilding.getStartPoint() < b.getStartPoint() &&
                                rightBuilding.getEndPoint() > b.getEndPoint()) ||
                        (rightBuilding.getStartPoint() > b.getStartPoint() &&
                                rightBuilding.getEndPoint() < b.getEndPoint())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if building fits to street
     *
     * @param b The building that you want to check.
     * @return A boolean value.
     */
    public boolean isBuildingFitsToStreet(Building b){  //Checks if building fits to street.
        return (b.getStartPoint() + b.getLength() <= this.getStreetLength());
    }

    /**
     * If inputs are valid, the building is added to the LinkedList
     *
     * @param var The building that is being added to the LinkedList.
     * @return The method returns true if the building is added to the LinkedList, and false if the building is not added to
     * the LinkedList.
     */
    public boolean add(Building var){
        if(checkInputsValidity(var)){   //If inputs are valid, continues. Then, returns false.
            if(var.getPosition() == 1){
                leftBuildings.add(var);  //New element is added to LinkedList.
            }
            else{
                rightBuildings.add(var);
            }
            return true;
        }
        else{
            System.out.println("Building's one or more input is invalid, please add valid building");
        }
        return false;
    }

    /**
     * Given a position and an index, remove the building at that position and index
     *
     * @param pos The position of the building that will be removed.
     * @param index The index of the building that will be removed.
     */
    public void remove(int pos, int index) throws IndexOutOfBoundsException{
        if(pos == 1){   //If pos == 1 --> building that will be removed is on the left.
            leftBuildings.remove(index);
        }
        else{
            rightBuildings.remove(index);
        }
    }

    /**
     * This function returns the total length of all the houses in the street
     *
     * @return The total length of all the houses in the street.
     */
    public int totalHouseLength(){
        int total = 0;
        Building right, left;
        for (Building rightBuilding : this.rightBuildings) {    //Searched rightBuilding array
            right = rightBuilding;
            if (right instanceof House) {                   //if it is Instance of House object,
                total = total + right.getLength();          //total = total + object.getLength()
            }
        }
        for (Building leftBuilding : this.leftBuildings) {      //Same for leftBuilding array
            left = leftBuilding;
            if (left instanceof House) {
                total = total + left.getLength();
            }
        }
        return total;
    }

    /**
     * This method returns the total length of all the offices in the street
     *
     * @return The total length of all the offices in the street.
     */
    public int totalOfficeLength(){     //I do the same things as totalHouseLength method
        int total = 0;
        Building right, left;
        for (Building rightBuilding : this.rightBuildings) {
            right = rightBuilding;
            if (right instanceof Office) {
                total = total + right.getLength();
            }
        }
        for (Building leftBuilding : this.leftBuildings) {
            left = leftBuilding;
            if (left instanceof Office) {
                total = total + left.getLength();
            }
        }
        return total;
    }

    /**
     * Returns the total length of all the markets in the street
     *
     * @return The total length of all the markets in the street.
     */
    public int totalMarketLength(){     //I do the same things as totalHouseLength method
        int total = 0;
        Building right, left;
        for (Building rightBuilding : this.rightBuildings) {
            right = rightBuilding;
            if (right instanceof Market) {
                total = total + right.getLength();
            }
        }
        for (Building leftBuilding : this.leftBuildings) {
            left = leftBuilding;
            if (left instanceof Market) {
                total = total + left.getLength();
            }
        }
        return total;
    }

    /**
     * This method returns the total length of all playgrounds in the street
     *
     * @return The total length of the playgrounds.
     */
    public int totalPlaygroundLength(){     //I do the same things as totalHouseLength method
        int total = 0;
        Building right, left;
        for (Building rightBuilding : this.rightBuildings) {
            right = rightBuilding;
            if (right instanceof Playground) {
                total = total + right.getLength();
            }
        }
        for (Building leftBuilding : this.leftBuildings) {
            left = leftBuilding;
            if (left instanceof Playground) {
                total = total + left.getLength();
            }
        }
        return total;
    }


    /**
     * This function calculates the remaining length of the street after the houses, offices, markets and playgrounds are
     * built
     */
    public void remainingLength(){      //Street has two side. Thus, I multiply the street length by 2. Then, I extracted building lengths.
        int remaining = (this.getStreetLength()*2) - (totalHouseLength() + totalOfficeLength() +
                totalMarketLength() + totalPlaygroundLength());
        System.out.println("Total Remanining Length is: " + remaining);
    }


    /**
     * Prints out the names of the buildings on the left and right sides of the street
     */
    public void listOfBuildings(){
        Building right, left;
        int biggerSize = Math.max(this.leftBuildings.size(), this.rightBuildings.size());
        System.out.println("\tLeft Side Buildings\t\t\t\t\tRight Side Buildings");
        System.out.println("----------------------------\t\t----------------------------");

        for(int i = 0 ; i < biggerSize ; i++){
            System.out.print("\t\t");
            if(!(i >= this.leftBuildings.size())){
                left = this.leftBuildings.get(i);
                System.out.print(left.getClass().getName());
            }
            System.out.print("\t\t\t\t\t\t\t\t");
            if(!(i >= this.rightBuildings.size())){
                right = this.rightBuildings.get(i);
                System.out.print(right.getClass().getName());
            }
            System.out.print("\n\n");
        }
    }

    /**
     * This function counts the number of playgrounds in the street and the ratio of playgrounds in the street
     */
    public void numberAndRatioPlaygrounds(){
        int number = 0;
        double ratioOfPlayground = 0.0;
        Building right, left;
        for (Building rightBuilding : this.rightBuildings) {
            right = rightBuilding;
            if (right instanceof Playground) {
                number++;
            }
        }
        for (Building leftBuilding : this.leftBuildings) {
            left = leftBuilding;
            if (left instanceof Playground) {
                number++;
            }
        }
        ratioOfPlayground = (float) totalPlaygroundLength()/(this.streetLength*2);
        System.out.println("\nNumber of Playgrounds in the Street: " + number);
        System.out.println("Ratio of Playgrounds in the Street: " + (String.format("%.2f", ratioOfPlayground)));
    }

    /**
     * This function calculates the total length of the street occupied by the houses, offices and markets
     */
    public void lengthOfMarketHouseOffice(){
        System.out.println("\nTotal Length of Street Occupied by the Houses: "+totalHouseLength());
        System.out.println("Total Length of Street Occupied by the Offices: "+totalOfficeLength());
        System.out.println("Total Length of Street Occupied by the Markets: "+totalMarketLength()+"\n");
    }

    public void skylineSilhouette(){
        int i,j,highestRight = 0, highestLeft = 0;

    }

    /**
     * This method checks if the building fits to street, if the inputs are valid and if there is conflict.
     * If building appropriate to street, returns true.
     *
     * @param b the building to be added to the street.
     * @return A boolean value.
     */
    public boolean checkInputsValidity(Building b){
        return (this.isBuildingFitsToStreet(b) &&           //I concatenate all validity methods in here.
                b.isInputValid() && !this.isConflict(b));
    }

    /**
     * It returns the street length.
     *
     * @return The streetLength variable is being returned.
     */
    public int getStreetLength() {
        return streetLength;
    }

    /**
     * It sets the street length.
     *
     * @param streetLength The length of the street in miles.
     */
    public void setStreetLength(int streetLength) {
        this.streetLength = streetLength;
    }
}
