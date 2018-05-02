package Udacity;

import java.util.Scanner;
public class GuessTheNumber {
    public static void main(String args[]){
        boolean hasWon = false;
     int randomNum = (int) (Math.random()*100+1);
     System.out.println("Guess the number between 1-100");
     for (int i=10;i>=0;i--){
         Scanner scan = new Scanner(System.in);
         System.out.println("You have "+i+" chances left");
         int guess = scan.nextInt();
         if (randomNum <guess) System.out.println("Its smaller");
         if (randomNum >guess) System.out.println("Its greater");
         if (randomNum ==guess) {
             hasWon=true;
             break;
         }

     }
     if (hasWon){
         System.out.println("You WON");
     }
     else System.out.println("You LOSE");
    }
}
