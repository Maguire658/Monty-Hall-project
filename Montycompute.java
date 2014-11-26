/**
 *
 * @author david
 */

import java.util.Random;
import java.util.Scanner;

public class Montycompute {
    Random gen = new Random();
    Scanner key = new Scanner(System.in);
    
    private int door1 = 0;
    private int door2 = 0;
    private int door3 = 0;
    
    private int carDoor = 0;
    private int goat1 = 0;
    private int goat2 = 0;
    
    private int initialGuess = 0;
    private int secondGuess = 0;
    
    private int stayWin = 0;
    private int switchWin = 0;
    private int stayLose = 0;
    private int switchLose = 0;
    
    public void setDoors(){
            while(door1 == door2 || door2 == door3 || door1 == door3) {
                door1 = gen.nextInt(3);
                door2 = gen.nextInt(3);
                door3 = gen.nextInt(3);
            }
        }
    public void setInitialGuess(){
        System.out.println("Where do you think the car is?");
        while(!key.hasNextInt()) {
            System.out.println("Please type an integer!");
            key.nextLine();
        }
        initialGuess = key.nextInt(); 
    }
     
    public int findCar(){
        if (door1 == 1) {
            carDoor = 1;
            goat1 = 2;
            goat2 = 3;
            return door1;
        }
        else if (door2 == 1) {
            carDoor = 2;
            goat1 = 1;
            goat2 = 3;
            return door2;
        }
        else {
            carDoor = 3;
            goat1 = 1;
            goat2 = 2;
            return door3;
        }
    }
    
    public void setSecondGuess(){
        if (initialGuess == carDoor){
             System.out.println("Behind door number " + (goat1) + " is a goat. "
                     + "Switch or Stay?");
            while(!key.hasNextInt()) {
            System.out.println("Please type an integer!");
            key.nextLine();
        }
            secondGuess = key.nextInt();
            while(secondGuess == goat1) {
                System.out.println("Don't pick that one! Give it another go");
                secondGuess = key.nextInt();         
             
             }
             
        }

        else if (initialGuess == goat1) {
                System.out.println("Behind door number " + goat2 + " is a goat. "
                     + "Switch or Stay?");
                while(!key.hasNextInt()) {
                System.out.println("Please type an integer!");
                key.nextLine();
                }
                secondGuess = key.nextInt();
                while(secondGuess == goat2) {
                System.out.println("Don't pick that one! Give it another go");
                while(!key.hasNextInt()) {
                System.out.println("Please type an integer!");
                key.nextLine();
            }
                secondGuess = key.nextInt();
                }
        }

        else if (initialGuess == goat2) {
            System.out.println("Behind door number " + goat1 + " is a goat. "
                     + "Switch or Stay?");
            while(!key.hasNextInt()) {
            System.out.println("Please type an integer!");
            key.nextLine();
            }
            secondGuess = key.nextInt();
            while(secondGuess == goat1) {
                System.out.println("Don't pick that one! Give it another go");
                while(!key.hasNextInt()) {
                System.out.println("Please type an integer!");
                key.nextLine();
            }
                secondGuess = key.nextInt();
            }
        }

        while(secondGuess > 3 || secondGuess <1) {
            System.out.println(
                    "You have not entered a valid door number between 1 and 3. "
                    + "Your initial choice was " 
                    + initialGuess 
                    + ". Try again");
            while(!key.hasNextInt()) {
            System.out.println("Please type an integer!");
            key.nextLine();
            }
            secondGuess = key.nextInt();
        }
        
        System.out.println("Your inital guess was door " + initialGuess
                + " and your second guess is " + secondGuess
        );

    }
    
    public int process() {
        if(initialGuess == carDoor && secondGuess == carDoor) {
            
            stayWin = 1;
            return stayWin; 
        }
        
        else if (initialGuess != carDoor && secondGuess == initialGuess){
            //System.out.println("You stayed and lost!");
            stayLose = 2;
            return stayLose;
        }
        
        else if (initialGuess != carDoor && secondGuess == carDoor) {
            //System.out.println("You switched and won!");
            switchWin = 3;
            return switchWin;
        
        }
        else if (initialGuess == carDoor && secondGuess != carDoor) {
            //System.out.println("You switched and lost!");
            switchLose = 4;
            return switchLose;
        
        }
        
        else {
            //System.out.println("Generated an error in process method");
            return 5;
        }
        
    }
}
    



    
 
    
    
    


