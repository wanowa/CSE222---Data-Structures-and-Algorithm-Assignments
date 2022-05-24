import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean b = true;                       //My boolean. I use it for while loop.
        int choose = 0;                         //"choose" variable takes choice of user.
        Scanner sc = new Scanner(System.in);
        while (b){
            System.out.println("\nSelect an option:");
            System.out.println("1) Run Interactive Program");
            System.out.println("2) Run Drive Code");
            System.out.println("3) Exit");
            try {
                choose = Integer.parseInt(sc.nextLine());   //Reading input from user
            }
            catch (NumberFormatException ex){       //If user enters string instead of integer, it will be throw an exception.
                System.err.println("Exception handled. Entered input is invalid, try again.");
                continue;
            }
            if(choose == 1){                        //Menu case
                Interactive interactive = new Interactive();
                interactive.menu();
            }
            else if(choose == 2){                   //Driver case
                Driver driver = new Driver();
                driver.start();
            }
            else if(choose == 3){                   //Exit case
                b = false;
                System.out.println("\nExiting...\n");
            }
            else{                                   //Input is invalid
                System.out.println("Entered input is out of range, try again.\n");
            }
        }
    }
}