public class Driver {
    public void start(){

        Street street1 = new Street(30);

        //I create the buildings that are on the left side of the street
        House house1 = new House(5,10,8,1,5,"blue","owner1");
        Playground playground1 = new Playground(15,4,1);
        Office office1 = new Office(19,7,12,1,"Job1","owner2");

        //I create the buildings that are on the right side of the street
        Market market1 = new Market(3,15,8,2,"08:30","21:00","owner3");
        Office office2 = new Office(18,8,15,2,"a101","owner4");
        Office office3 = new Office(20,4,5,2,"bim","owner5");

        street1.add(house1);        //Adding house to left side of the street.
        street1.add(playground1);   //Adding playground to left side of the street.
        street1.add(office1);       //Adding office to left side of the street.

        street1.add(market1);       //Adding market to right side of the street
        street1.add(office2);       //Adding office to right side of the street
        street1.add(office3);       //Ikinci office (office3) street'e eklenmiyor, cunku koordinatlari diğer office
                                    //objesi ile kesisiyor.
        street1.listOfBuildings();  //List of Buildings'de de görüldüğü gibi caddenin sağında sadece tek bir office var
        street1.remainingLength();
        street1.numberAndRatioPlaygrounds();
        street1.lengthOfMarketHouseOffice();

        System.out.println("---------------------------------------------------------------------------------------\n\n");

        Street street2 = new Street(50);

        //I create the buildings that are on the left side
        House house2 = new House(0,6,10,1,4,"red","owner1");
        House house3 = new House(7,6,7,1,5,"purple","owner2");
        Playground playground2 = new Playground(13,4,1);
        Market market2 = new Market(17,15,15,1,"10:00","23:00","owner3");
        Playground playground3 = new Playground(32,6,1);
        House house4 = new House(38,12,20,1,7,"brown","owner4");

        //I create the buildings that are on the right side of the street
        Office office4 = new Office(0,20,10,2,"Mall","owner5");
        Office office5 = new Office(25,7,20,2,"Business Center","owner6");
        Playground playground4 = new Playground(32,10,2);
        Market market3 = new Market(42,8,10,2,"07:00","22:00","owner7");

        street2.add(house2);            //Adding house to left side of the street.
        street2.add(house3);            //Adding house to left side of the street.
        street2.add(playground2);       //Adding playground to left side of the street.
        street2.add(market2);           //Adding market to left side of the street
        street2.add(playground3);       //Adding playground to left side of the street.
        street2.add(house4);            //Adding house to left side of the street.

        street2.add(office4);           //Adding office to right side of the street.
        street2.add(office5);           //Adding office to right side of the street.
        street2.add(playground4);       //Adding playground to right side of the street.
        street2.add(market3);           //Adding market to right side of the street.

        street2.listOfBuildings();        //Listing all buildings
        street2.remainingLength();
        street2.numberAndRatioPlaygrounds();
        street2.lengthOfMarketHouseOffice();

        System.out.println("---------------------------------------------------------------------------------------\n\n");

                                          //I remove playgrounds from street.
        street2.remove(1,2);    //Normally, second playground was at 4th index,
        street2.remove(1,3);    //but when I delete first playground, it
        street2.remove(2,2);    //moves to 3rd index. So, to delete playgrounds
                                          //from my street, i remove 3rd index.
        street2.listOfBuildings();        //Listing buildings except removing ones.
        street2.remainingLength();
        street2.numberAndRatioPlaygrounds();
        street2.lengthOfMarketHouseOffice();

        System.out.println("---------------------------------------------------------------------------------------\n\n");

        street2.remove(1,0);    //I'm removing all buildings from street.
        street2.remove(1,0);    //I just remove 0th indexes, because when i remove an element from
        street2.remove(1,0);    //street, next elements shifts automatically to the left.
        street2.remove(1,0);

        street2.remove(2,0);
        street2.remove(2,0);
        street2.remove(2,0);

        street2.listOfBuildings();        //Listing empty buildings.
        street2.remainingLength();
        street2.numberAndRatioPlaygrounds();
        street2.lengthOfMarketHouseOffice();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");

    }
}