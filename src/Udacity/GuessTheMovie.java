package Udacity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
public class GuessTheMovie {
    public static void main(String args[]) throws Exception{
        File f = new File("/home/shekhar/IdeaProjects/MyFirst/src/Udacity/movies.txt");
        Scanner scan = new Scanner(f);
        Scanner sc = new Scanner(System.in);
        int total_file_line_num = 0;
        System.out.println("Welcome to the Game Guess The Movie name!!");
        System.out.println("You can only guess 10 wrong letters");
        while(scan.hasNextLine()){
            scan.nextLine();
            total_file_line_num++;
        }
        int randomNum = (int) (Math.random()*total_file_line_num);
        String movie_name = Files.readAllLines(Paths.get("/home/shekhar/IdeaProjects/MyFirst/src/Udacity/movies.txt")).get(randomNum-1);
        String hidden_movie_name = movie_name.replaceAll("\\w","*");
        System.out.println(hidden_movie_name);
        int char_position;
        String guessed = " ";

        int i = 10;

        while (i>0){
            String dup_movie_name = movie_name;

            System.out.println("Enter the Guessed letter");
            char letter = sc.next().charAt(0);
            char_position = movie_name.indexOf(letter);

            if (char_position>=0){
                guessed=guessed.concat(String.valueOf(letter));
                dup_movie_name = dup_movie_name.replaceAll("[^"+guessed+"]","*");

                System.out.println(dup_movie_name);
                if (!dup_movie_name.contains("*")){
                    System.out.println("You won");
                    break;}
            }
            else{
                i--;
                System.out.println("WRONG GUESS!! "+i+" Guess(es) remaining");
            }

        }
        if (i==0) System.out.println("Out of guesses! You Lost!!");
    }
}