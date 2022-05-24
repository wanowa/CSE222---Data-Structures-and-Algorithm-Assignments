import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Interactive mode for User
 */
public class Interactive {

    ////////////////////////////////////////////
    private Street street = new Street();
    ////////////////////////////////////////////

    /**
     * This function is used to display the menu of the program
     */
    public void menu(){
        int tempLen = 0;
        boolean isValid = false;
        int choose;
        Scanner sc = new Scanner(System.in);
        while(!isValid){
            System.out.println("Enter Street Length = ");
            try {
                tempLen = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException ex){
                System.err.println("Exception handled. Entered input is invalid, try again.");
                continue;
            }
            isValid = true;
        }
        street.setStreetLength(tempLen);

        boolean b = true;

        while(b){
            boolean myException = false;
            System.out.println("\nChoose one of the followings: \n\n 1) Edit Mode \n 2) View Mode \n 3) Return to Main Menu...");
            try {
                choose = takeMenuInput();
            }catch (InputMismatchException ex){
                myException = true;
                System.err.println("Exception handled. Entered input is invalid, try again.");
                continue;
            }
            if(!myException){
                if(choose == 1)
                    editMode();
                else if(choose == 2)
                    viewMode();
                else if(choose == 3){
                    b = false;
                    System.out.println("\nReturning Back to Main Menu...");
                }
                else{
                    System.out.println("Entered input is out of range, try again.\n");
                }
            }
        }
    }

    /**
     * Editing Mode of Software.
     * Adding and deleting is performed.
     */
    public void editMode(){
        int choose;
        boolean b = true;
        while(b){
            boolean myException = false;
            System.out.println("Choose one of the followings: \n\n 1) Add Building \n 2) Delete Building \n 3) Return to Menu");
            try {
                choose = takeMenuInput();
            }catch (InputMismatchException ex){
                myException = true;
                System.err.println("Entered input is invalid, try again.");
                continue;
            }
            if(!myException){
                if(choose == 1)
                    addNewBuilding();
                else if(choose == 2)
                    deleteBuilding();
                else if(choose == 3)
                    b = false;
                else{
                    System.out.println("Entered input is out of range, try again.\n");
                }
            }
        }
    }

    /**
     * This function is used to display the information of the street.
     *     It has 7 options to choose from.
     *     The user can choose one of the options by entering the number of the option.
     *     If the user enters a number out of the range, it will be displayed an error message.
     *     If the user enters a string instead of an integer, it will be displayed an error message.
     *     If the user enters a number in the range, it will be displayed the information of the street.
     *     If the user enters 7, it will be returned to the menu
     */
    public void viewMode(){
        int choose, index, side;
        boolean b = true;
        while(b){
            boolean myException = false, myBool = true;
            System.out.println("\nChoose one of the followings:");
            System.out.println("1) Display the total remaining length of lands on the street");
            System.out.println("2) Display the list of buildings on the street");
            System.out.println("3) Display the number and ratio of length of playgrounds in the street");
            System.out.println("4) Calculate the total length of street occupied by the markets, houses or offices");
            System.out.println("5) Display the skyline silhouette of the street");
            System.out.println("6) Display focused informations of buildings");
            System.out.println("7) Return to Menu");
            try {   //If user tries to enter string instead of integer, it will be throw an exception.
                choose = takeMenuInput();
            }catch (InputMismatchException ex){
                myException = true;
                System.err.println("Entered input is invalid, try again.");
                continue;
            }
            if(!myException){
                if(choose == 1)
                    street.remainingLength();
                else if(choose == 2)
                    street.listOfBuildings();
                else if(choose == 3)
                    street.numberAndRatioPlaygrounds();
                else if(choose == 4)
                    street.lengthOfMarketHouseOffice();
                else if(choose == 5)
                    street.skylineSilhouette();
                else if(choose == 6){
                    while(myBool){
                        try {   //If user tries to enter string instead of integer, it will be throw an exception.
                            System.out.println("Enter buildings side");
                            side = takeMenuInput();
                            System.out.println("Enter buildings index");
                            index = takeMenuInput();
                        }catch (InputMismatchException ex){
                            System.err.println("Entered input is invalid, try again.");
                            continue;
                        }
                        if(!(side == 1 || side == 2)){      //Checking inputs validity
                            System.out.println("Entered input is out of range, try again.\n");
                            continue;
                        }
                        street.printBuildingInformation(side,index);
                        myBool = false;
                    }
                }
                else if(choose == 7)
                    b = false;
                else{       //Checking inputs validity
                    System.out.println("Entered input is out of range, try again.\n");
                }
            }
        }
    }

    /**
     * Asks building type from user and adds it to the city
     */
    public void addNewBuilding(){   //Asks building type from user
        int choose;
        boolean b = true;
        while(b){
            boolean myException = false;
            System.out.println("Select the building you want to add:\n");
            System.out.println("1) House\n2) Office\n3) Market\n4) Playground\n5) Go Back");
            try {
                choose = takeMenuInput();
            }catch (InputMismatchException ex){
                myException = true;
                System.err.println("Exception Handled. Entered input is invalid, try again.");
                continue;
            }
            if(!myException){
                if(choose == 1)
                    addHouse();
                else if(choose == 2)
                    addOffice();
                else if(choose == 3)
                    addMarket();
                else if(choose == 4)
                    addPlayground();
                else if(choose == 5){
                    b = false;
                    System.out.println("\nGoing Upper Menu...");
                }
                else{
                    System.out.println("Entered input is out of range, try again.\n");
                }
            }
        }
    }

    /**
     * Asks building's index and side from user, then removes the building from the street
     */
    public void deleteBuilding(){   //Asks building's index and side from user
        int index, side;
        boolean myException = false, b = true;
        while (b){
            try {
                System.out.println("Enter the side of building you want to delete(1 For Left, 2 For Right):");
                side = takeMenuInput();
                System.out.println("\nEnter the index of building you want to delete:");
                index = takeMenuInput();
                if(!myException){
                    if(side == 1){
                        b = false;
                        street.remove(side,index);
                    }
                    else if(side == 2){
                        b = false;
                        street.remove(side,index);
                    }
                    else{
                        System.out.println("Entered input is out of range, try again.\n");
                    }
                }
            }catch (InputMismatchException | IndexOutOfBoundsException ex){
                myException = true;
                System.err.println("Exception Handled. Entered input is invalid, try again.");
            }
        }
    }

    /**
     * This method just takes an input from user and returned it
     *
     * @return The method returns an integer value.
     * @throws InputMismatchException
     */
    public int takeMenuInput()throws InputMismatchException {   //This method just takes an input from user and returned it
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * It adds a house to the street.
     */
    public void addHouse(){
        House house = new House();
        boolean isValid = false;
        while (!isValid){
            try{
                house = (House) setProperties(1);
            }catch (NumberFormatException ex){
                System.err.println("Entered input is invalid, try again.");
                continue;
            }
            isValid = true;
        }
        street.add(house);  //If object is valid, then we can add this to the street
        System.out.println("House Added to Street Successfully!\n");
    }

    /**
     * It adds an office to the street.
     */
    public void addOffice(){
        Office office = new Office();
        boolean isValid = false;
        while (!isValid){
            try{
                office = (Office) setProperties(2);
            }catch (NumberFormatException ex){
                System.err.println("Entered input is invalid, try again.");
                continue;
            }
            isValid = true;
        }
        street.add(office);     //If object is valid, then we can add this to the street
        System.out.println("Office Added to Street Successfully!\n");
    }

    /**
     * This function adds a market to the street.
     */
    public void addMarket(){
        Market market = new Market();
        boolean isValid = false;
        while (!isValid){
            try{
                market = (Market) setProperties(3);
            }catch (NumberFormatException ex){
                System.err.println("Entered input is invalid, try again.");
                continue;
            }
            isValid = true;
        }
        street.add(market);     //If object is valid, then we can add this to the street
        System.out.println("Market Added to Street Successfully!\n");
    }

    /**
     * It adds a playground to the street.
     */
    public void addPlayground(){
        Playground playground = new Playground();
        boolean isValid = false;
        while (!isValid){
            try{
                playground = (Playground) setProperties(4);
            }catch (NumberFormatException ex){
                System.err.println("Entered input is invalid, try again.");
                continue;
            }
            isValid = true;
        }
        street.add(playground);     //If object is valid, then we can add this to the street
        System.out.println("Playground Added to Street Successfully!\n");
    }

    /**
     * This function is used to set the properties of the building
     *
     * @param buildingType This is the type of building that the user wants to add.
     * @return The object of the building type.
     * @throws NumberFormatException
     */
    public Building setProperties(int buildingType)throws NumberFormatException{
        int position = 0,startP = 0, endP = 0, length = 0, height = 0, numberOfRooms = 0;
        String owner = "", color = "", jobType = "", openTime = "", closeTime = "";
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        House house = new House();
        Office office = new Office();
        Market market = new Market();
        Playground playground = new Playground();

        while(!isValid){    //Continue if inputs are not valid
            System.out.println("--------------------------------------------");
            System.out.println("Enter the position of the building(1 for left, 2 for right");
            position = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the starting point of the building:");
            startP = Integer.parseInt(sc.nextLine());
            System.out.println("\nEnter the length of the building:");
            length = Integer.parseInt(sc.nextLine());
            endP = startP + length;

            if(buildingType != 4){      //Height and owner are common data of House, Market and Office.
                System.out.println("\nEnter the height of the building:");
                height = Integer.parseInt(sc.nextLine());
                System.out.println("\nEnter the owner of the building:");
                owner = sc.nextLine();
            }
            if(buildingType == 1){      //This is for house
                System.out.println("\nEnter the number of rooms of the house:");
                numberOfRooms = Integer.parseInt(sc.nextLine());
                System.out.println("\nEnter the color of the house:");
                color = sc.nextLine();
                house.setPosition(position);
                house.setStartPoint(startP);
                house.setEndPoint(endP);
                house.setLength(length);
                house.setHeight(height);
                house.setNumOfRooms(numberOfRooms);
                house.setOwner(owner);
                house.setColor(color);
                if(street.checkInputsValidity(house)){
                    isValid = true;
                }
                else{
                    System.out.println("Entered One or More Inputs are invalid, please try again.");
                }
            }
            if(buildingType == 2){      //This is for office
                System.out.println("\nEnter the job type of the office:");
                jobType = sc.nextLine();
                office.setPosition(position);
                office.setStartPoint(startP);
                office.setEndPoint(endP);
                office.setLength(length);
                office.setHeight(height);
                office.setOwner(owner);
                office.setJobType(jobType);
                if(street.checkInputsValidity(office)){
                    isValid = true;
                }
                else{
                    System.out.println("Entered One or More Inputs are invalid, please try again.");
                }
            }
            if(buildingType == 3){      //This is for market
                System.out.println("\nEnter the opening time of the market:");
                openTime = sc.nextLine();
                System.out.println("\nEnter the closing time of the market:");
                closeTime = sc.nextLine();
                market.setPosition(position);
                market.setStartPoint(startP);
                market.setEndPoint(endP);
                market.setLength(length);
                market.setHeight(height);
                market.setOwner(owner);
                market.setOpeningTime(openTime);
                market.setClosingTime(closeTime);
                if(street.checkInputsValidity(market)){
                    isValid = true;
                }
                else{
                    System.out.println("Entered One or More Inputs are invalid, please try again.");
                }
            }
            if(buildingType == 4){      //This is for playground
                playground.setPosition(position);
                playground.setStartPoint(startP);
                playground.setEndPoint(endP);
                playground.setLength(length);
                if(street.checkInputsValidity(playground)){
                    isValid = true;
                }
                else{
                    System.out.println("Entered One or More Inputs are invalid, please try again.");
                }
            }
        }
        if(buildingType == 1){  //Returning objects to add methods.
            return house;
        }
        else if(buildingType == 2){
            return office;
        }
        else if(buildingType == 3){
            return market;
        }
        else{
            return playground;
        }
    }
}
