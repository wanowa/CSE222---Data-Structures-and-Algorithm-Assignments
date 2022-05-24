import java.util.*;

public class Street {
    private int streetLength;       //Length of the street
    private static final int initialCapacity = 10;  //Initial capacity of building array
    private int leftSize;       //Size of the buildings on the left
    private int leftCapacity;   //Capacity of the buildings on the left
    private int rightSize;      //Size of the buildings on the right
    private int rightCapacity;  //Capacity of the buildings on the right
    private Building[] rightBuildings;  //Building array of the buildings on the right
    private Building[] leftBuildings;   //Building array of the buildings on the right

    public Street(){        //My default constructor. I initialize my fields.
        this.rightBuildings = new Building[initialCapacity];
        this.leftBuildings = new Building[initialCapacity];
        this.streetLength = 0;
        this.leftSize = 0;
        this.leftCapacity = initialCapacity;
        this.rightSize = 0;
        this.rightCapacity = initialCapacity;
    }

    public Street(int streetLength) {
        this.streetLength = streetLength;
        this.rightBuildings = new Building[initialCapacity];
        this.leftBuildings = new Building[initialCapacity];
        this.leftSize = 0;
        this.leftCapacity = initialCapacity;
        this.rightSize = 0;
        this.rightCapacity = initialCapacity;
    }

    public void printBuildingInformation(int side, int index){
        if(side == 1){                          //Prints some informations
            leftBuildings[index].focus();       //about building
        }
        else{
            rightBuildings[index].focus();
        }
    }

    public Building getRightBuilding(int index){
        return this.rightBuildings[index];
    }

    public Building getLeftBuilding(int index){
        return this.leftBuildings[index];
    }

    public boolean isConflict(Building b){  //This method checks if two building is conflict. If so, returns true, otherwise return false.
        if(b.getPosition() == 1){       //If getPosition() == 1 --> Buildings are on the left
            for(int i = 0 ; i < this.leftSize ; i++){
                if((this.leftBuildings[i].getStartPoint() > b.getStartPoint() &&    //I checked all situations that buildings are conflict.
                    this.leftBuildings[i].getStartPoint() < b.getEndPoint()) ||
                    (this.leftBuildings[i].getEndPoint() > b.getStartPoint() &&
                    this.leftBuildings[i].getEndPoint() < b.getEndPoint()) ||
                    (this.leftBuildings[i].getStartPoint() < b.getStartPoint() &&
                    this.leftBuildings[i].getEndPoint() > b.getEndPoint()) ||
                    (this.leftBuildings[i].getStartPoint() > b.getStartPoint() &&
                    this.leftBuildings[i].getEndPoint() < b.getEndPoint())){
                        return true;
                }
            }
        }
        else{       //Else --> Buildings are on the left
            for(int i = 0 ; i < this.rightSize ; i++){
                if((this.rightBuildings[i].getStartPoint() > b.getStartPoint() &&   //I checked all situations that buildings are conflict.
                    this.rightBuildings[i].getStartPoint() < b.getEndPoint()) ||
                    (this.rightBuildings[i].getEndPoint() > b.getStartPoint() &&
                    this.rightBuildings[i].getEndPoint() < b.getEndPoint()) ||
                    (this.rightBuildings[i].getStartPoint() < b.getStartPoint() &&
                    this.rightBuildings[i].getEndPoint() > b.getEndPoint()) ||
                    (this.rightBuildings[i].getStartPoint() > b.getStartPoint() &&
                    this.rightBuildings[i].getEndPoint() < b.getEndPoint())){
                        return true;
                }
            }
        }
        return false;
    }

    public boolean isBuildingFitsToStreet(Building b){  //Checks if building fits to street.
        return (b.getStartPoint() + b.getLength() <= this.getStreetLength());
    }

    public boolean add(Building var){

        if(checkInputsValidity(var)){   //If inputs are valid, continues. Then, returns false.
            if(var.getPosition() == 1){
                if(leftSize == leftCapacity){   //If capacity is full, I reallocate
                    reallocate(1);          //and expand my building array
                }
                leftBuildings[leftSize] = var;  //New element is added to array.
                leftSize++;     //Size increased.
            }
            else{
                if(rightSize == rightCapacity){
                    reallocate(2);
                }
                rightBuildings[rightSize] = var;
                rightSize++;
            }
            return true;
        }
        return false;
    }

    public boolean remove(int pos, int index){
        int i;
        if(pos == 1){   //If pos == 1 --> building that will be removed is on the left.
            for(i=index+1;i<leftSize;i++){
                leftBuildings[i-1] = leftBuildings[i];  //I removed that element with shifting
            }
            leftBuildings[leftSize-1] = null;
            leftSize--;     //Size decreased
        }
        else{
            for(i=index+1;i<rightSize;i++){
                rightBuildings[i-1] = rightBuildings[i];
            }
            rightBuildings[rightSize-1] = null;
            rightSize--;
        }
        return true;
    }

    public void reallocate(int var){        //I create a temp building array to keep original array.
        Building[] tempBuildings;           //I assigned building array to temp array and reinitialize
        if(var == 1){                       //building array with double capacity. And save old datas,
            tempBuildings = leftBuildings;  //I copied temp array datas to building array.
            this.leftBuildings = new Building[leftCapacity*2];
            for(int i = 0 ; i < leftSize ; i++){
                leftBuildings[i] = tempBuildings[i];
            }
            leftCapacity = leftCapacity * 2;
        }
        else{
            tempBuildings = rightBuildings;
            this.rightBuildings = (Building[]) new Object[rightCapacity*2];
            for(int i = 0 ; i < rightSize ; i++){
                rightBuildings[i] = tempBuildings[i];
            }
            rightCapacity = rightCapacity * 2;
        }
    }

    public int totalHouseLength(){
        int total = 0;
        Building right, left;
        for(int i = 0 ; i < this.getRightSize() ; i++) {    //Searched rightBuilding array
            right = this.getRightBuilding(i);
            if (right instanceof House) {                   //if it is instance of House object,
                total = total + right.getLength();          //total = total + object.getLength()
            }
        }
        for(int j = 0 ; j < this.getLeftSize() ; j++){      //Same for leftBuilding array
            left = this.getLeftBuilding(j);
            if(left instanceof House){
                total = total + left.getLength();
            }
        }
        return total;
    }

    public int totalOfficeLength(){     //I do the same things as totalHouseLength method
        int total = 0;
        Building right, left;
        for(int i = 0 ; i < this.getRightSize() ; i++) {
            right = this.getRightBuilding(i);
            if (right instanceof Office) {
                total = total + right.getLength();
            }
        }
        for(int j = 0 ; j < this.getLeftSize() ; j++){
            left = this.getLeftBuilding(j);
            if(left instanceof Office){
                total = total + left.getLength();
            }
        }
        return total;
    }

    public int totalMarketLength(){     //I do the same things as totalHouseLength method
        int total = 0;
        Building right, left;
        for(int i = 0 ; i < this.getRightSize() ; i++) {
            right = this.getRightBuilding(i);
            if (right instanceof Market) {
                total = total + right.getLength();
            }
        }
        for(int j = 0 ; j < this.getLeftSize() ; j++){
            left = this.getLeftBuilding(j);
            if(left instanceof Market){
                total = total + left.getLength();
            }
        }
        return total;
    }

    public int totalPlaygroundLength(){     //I do the same things as totalHouseLength method
        int total = 0;
        Building right, left;
        for(int i = 0 ; i < this.getRightSize() ; i++) {
            right = this.getRightBuilding(i);
            if (right instanceof Playground) {
                total = total + right.getLength();
            }
        }
        for(int j = 0 ; j < this.getLeftSize() ; j++){
            left = this.getLeftBuilding(j);
            if(left instanceof Playground){
                total = total + left.getLength();
            }
        }
        return total;
    }

    public void remainingLength(){      //Street has two side. Thus, i multiply the street length by 2. Then, i extracted building lengths.
        int remaining = (this.getStreetLength()*2) - (totalHouseLength() + totalOfficeLength() +
                        totalMarketLength() + totalPlaygroundLength());
        System.out.println("Total Remanining Length is: " + remaining);
    }

    public void listOfBuildings(){      //I printed list of buildings here
        Building right, left;
        Formatter formatter = new Formatter();
        int biggerSize;
        if(this.getLeftSize() > this.getRightSize())
            biggerSize = leftSize;
        else{
            biggerSize = rightSize;
        }
        System.out.println("\tLeft Side Buildings\t\t\t\t\tRight Side Buildings");
        System.out.println("----------------------------\t\t----------------------------");

        for(int i = 0 ; i < biggerSize ; i++){
            System.out.print("\t\t");
            if(!(i >= this.getLeftSize())){
                left = this.getLeftBuilding(i);
                System.out.print(left.getClass().getName());
            }
            System.out.print("\t\t\t\t\t\t\t\t");
            if(!(i >= this.getRightSize())){
                right = this.getRightBuilding(i);
                System.out.print(right.getClass().getName());
            }
            System.out.print("\n\n");
        }
    }

    public void numberAndRatioPlaygrounds(){
        int number = 0;
        double ratioOfPlayground = 0.0;
        Building right, left;
        for(int i = 0 ; i < this.getRightSize() ; i++) {
            right = this.getRightBuilding(i);
            if (right instanceof Playground) {
                number++;
            }
        }
        for(int j = 0 ; j < this.getLeftSize() ; j++){
            left = this.getLeftBuilding(j);
            if(left instanceof Playground){
                number++;
            }
        }
        ratioOfPlayground = (float) totalPlaygroundLength()/(this.streetLength*2);
        System.out.println("\nNumber of Playgrounds in the Street: " + number);
        System.out.println("Ratio of Playgrounds in the Street: " + (String.format("%.2f", ratioOfPlayground)));
    }

    public void lengthOfMarketHouseOffice(){
        System.out.println("\nTotal Length of Street Occupied by the Houses: "+totalHouseLength());
        System.out.println("Total Length of Street Occupied by the Offices: "+totalOfficeLength());
        System.out.println("Total Length of Street Occupied by the Markets: "+totalMarketLength()+"\n");
    }

    public void skylineSilhouette(){
        int i,j,highestRight = 0, highestLeft = 0;

    }

    public boolean checkInputsValidity(Building b){
        return (this.isBuildingFitsToStreet(b) &&           //I concatenate all validity methods in here.
                b.isInputValid() && !this.isConflict(b));
    }

    public int getStreetLength() {
        return streetLength;
    }

    public void setStreetLength(int streetLength) {
        this.streetLength = streetLength;
    }

    public int getLeftSize() {
        return leftSize;
    }

    public void setLeftSize(int leftSize) {
        this.leftSize = leftSize;
    }

    public int getLeftCapacity() {
        return leftCapacity;
    }

    public void setLeftCapacity(int leftCapacity) {
        this.leftCapacity = leftCapacity;
    }

    public int getRightSize() {
        return rightSize;
    }

    public void setRightSize(int rightSize) {
        this.rightSize = rightSize;
    }

    public int getRightCapacity() {
        return rightCapacity;
    }

    public void setRightCapacity(int rightCapacity) {
        this.rightCapacity = rightCapacity;
    }
}
