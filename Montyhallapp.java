/**
 * @author david
 */

import java.util.Scanner;


public class Montyhallapp {
    public static void main(String args[]){
        Scanner key = new Scanner(System.in);
        int runtimeAmount = 0;
        int runtimeIterator = 1;
        int totalStayWins = 0;
        int totalStayLoss = 0;
        int totalSwitchWins = 0;
        int totalSwitchLoss = 0;
        
        
        System.out.println("How many times would you like to run the game?");
            while(!key.hasNextInt()) {
            System.out.println("Please type an integer!");
            key.nextLine();
        }
        runtimeAmount = key.nextInt();
        
        while(runtimeIterator <= runtimeAmount){
            Montycompute processor = new Montycompute(); 
            processor.setDoors();
            processor.findCar();
            processor.setInitialGuess();
            processor.setSecondGuess();
            
            if(processor.process() == 1) {
                totalStayWins++;
                System.out.println("You stayed and won!");
            }
            else if (processor.process() == 2) {
                totalStayLoss++;
                System.out.println("You stayed and lost!");
            }
            
            else if (processor.process() == 3) {
                totalSwitchWins++;
                System.out.println("You switched and won!");
            
            }
            else if (processor.process() == 4) {
                System.out.println("You switched and lost!");
                totalSwitchLoss++;
            
            }
            else { System.out.println("Generated an error in process method");}
            runtimeIterator++;
            System.out.println("End of loop");
            System.out.println();
            System.out.println();
            }
        
        System.out.println("Wins by staying >>  " + totalStayWins );
        System.out.println("Loss by staying >>  " + totalStayLoss );
        System.out.println("Wins by switching >>  " + totalSwitchWins );
        System.out.println("Loss by switching >>  " + totalSwitchLoss );
    }
}


/**
 * 
 * 
 * 
 *  input
 * 
 *  process
 * 
 *  output
 * 
 *  vars
 * 
 *  tasks
 *  * get runtime amount input and store in var
 *  * create loop
 *  * associate car / goats with door (string or int?)
 *  * get user choice and store
 *  * "Door x has a goat behind it". Do you wish to switch or stay.
 *     Possible if
 *  * Output if user has won or lost
 *  * Record if user won or lost
 *  * Record switches and stays
 * 
 * 
 * 
 * 
 * 
 */