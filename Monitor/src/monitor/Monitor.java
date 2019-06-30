/*
*
 * Southern NH University
 *
 * IT - 145 Foundations in Application Development
 * Final Project Monitor
 *
 * Instructor: Joe Parker
 *
 * Student: Hannah Brigman
 *
 * Date: 06/27/2019
 *
 *
 *
 * Description:
 *
 *
 */
package monitor;

/**
 *
 * @author HannahB
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Monitor {

private static Scanner usrch = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

    AnimalsHabitat methodCall = new AnimalsHabitat();
   

    try {

        int userChoice = mainMenu();

        switch(userChoice) {
            case 1:
                System.out.println("Please pick the animal you would like to monitor: ");
                System.out.println("");

                methodCall.askForWhichDetails("animals");
                
                System.out.println("Press 0 to go back.");
                
                break;

            case 2:
                System.out.println("Please pick the habitat you would like to monitor: ");
                System.out.println("");
                
                methodCall.askForWhichDetails("habitats");
                
                System.out.println("Press 0 to go back.");
                
                break;

            case 3:
                System.out.println("Have a nice day!");
                System.exit(0);
                
                break;

            default:
                int loopError = 0;

                while (loopError < 3) {
                    loopError++;
                    
                    if (loopError == 3) {
                        System.out.println("Error in program loop, exiting program.");
                        System.exit(0);
                    }
                } 
            }
        }

    catch (IOException e) {
        System.out.println("Wrong input " + e.getMessage());
    }
}

public static int mainMenu() {

    System.out.println("Welcome to the Zoo Monitoring System!");
    System.out.println("Please select what you would like to monitor: ");
    System.out.println("");
    System.out.println("1.) Animals");   
    System.out.println("2.) Habitats");   
    System.out.println("3.) Exit program");
    int userChoice = Integer.parseInt(usrch.nextLine());
    return userChoice;
}
}