// Author: Nabiha Bashir
// HumanPyramid Class

import java.util.Scanner;
import java.util.ArrayList;

public class HumanPyramid {


    //count weight in each person
    static double weightOnGuy(int row, int col){
        if (row == 1 && col == 1){   //person on top
            return 0;
        }
        else if (col == 1) {          //person with no one on left
            return ((150 + weightOnGuy((row - 1) , col))/2);
        }
        else if (col == row) {        //person with no one on right
            return ((150 + weightOnGuy(row - 1, col - 1 ))/2);
        }
        else{                        //persons in the middle
            return ((150) + (weightOnGuy(row - 1, col - 1)/2) + (weightOnGuy(row - 1, col )/2));
        }
    }

    //building pyramid
    public static void printPyramid(int numRows) {
        ArrayList<Integer> pyramid = new ArrayList<Integer>();

        //build pyramid
        for (int r = 1; r <= numRows; r++) {
            for (int c = 1; c <= r; c++) {

                //add weights to array
                int w = (int) (weightOnGuy(r, c));
                pyramid.add(w);
            }
        }

        //print pyramid
        int space;
        int count = 0;
        for (int r = 1; r <= numRows; r++) {
            space = numRows - r;
            //for loop for indenting
            for (int i = 0; i < space; i++) {
                System.out.print("   ");
            }

            //print weights
            for (int c = 1; c <= r; c++) {
                System.out.printf("(%4d)", pyramid.get(count));
                count++;
            }
            System.out.println();
        }
    }

    //Main function
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String runAgain;

        do {
            //ask users for height of pyramid (rows)
            System.out.println("How tall is your pyramid? (Enter number of rows): ");
            int numRows = in.nextInt();

            //display pyramid with weights
            System.out.println("Here is the graph of your pyramid showing the weight each person is holding");

            //display pyramid
            printPyramid(numRows);

            //ask users if they want to run it again
            System.out.println("Do you want to run again? (y/n): ");
            runAgain = in.next();

            //if yes, repeat otherwise end program
            if (runAgain.equals("n")){
                System.out.println("You have chosen to quit. Goodbye!");
            }
        }
        while(runAgain.equals("n") == false);
    }
}
