// Author: Nabiha Bashir
// SolitairePrime Class

package SolitairePrime;
import java.util.Scanner;
public class SolitairePrime {
    //Create menu
    public static int menu()
    {
        //Display menu
        System.out.println("Welcome to Solitaire Prime! \nMenu:");
        System.out.println("1) New Deck");
        System.out.println("2) Display Deck");
        System.out.println("3) Shuffle Deck");
        System.out.println("4) Play Solitaire Prime");
        System.out.println("5) Exit");

        //Get user input for menu selection
        Scanner in = new Scanner(System.in);
        System.out.println("\nMenu Selection: ");
        int userChoice = in.nextInt();
        return userChoice;
    }

    //Main function
    public static void main(String args[])
    {
        Deck newDeck = null;

        int userChoice;
        Card C;
        //do-while loop to execute menu options
        do
        {
            userChoice = menu(); //get user's choice from menu

            if(userChoice == 1)
            {
                newDeck = new Deck();
                System.out.println("A new deck has been created.\n");
            }
            else if (userChoice == 2)
            {
                newDeck.display();  //display entire deck
            }
            else if (userChoice == 3)
            {
                newDeck.shuffle();  //shuffle deck
                System.out.println("Deck has been shuffled.\n");
            }
            else if (userChoice == 4)
            {
                System.out.println("\nSolitaire Prime:");
                int sumValues = 0;
                int numPiles = 0;

                //use for loop to iterate over cards in storage
                for (int i = 0; i < 52; i++)
                {   //take top card
                    C = newDeck.deal();
                    //display card
                    C.display();
                    //separate cards
                    System.out.print(" ");
                    sumValues += (C.getValue());

                    //check if sum is prime
                    if(isPrime(sumValues))
                    {
                        System.out.println("Prime: " + sumValues);
                        sumValues = 0; //restart sum
                        numPiles++;
                    }
                }
                //Declare win
                if(sumValues == 0)
                {
                    System.out.println("Winner in " + numPiles + " piles!\n");
                }
                //Declare loss
                else {
                    System.out.println("Loser.");
                }
            }
            else if (userChoice == 5)
            {
                System.out.println("You have chosen to exit game. Goodbye!");
            }
            else  {
                System.out.println("Please select menu choices from 1-5.\n");
                menu(); //repeat menu

            }
            //execute user menu options as long as user doesn't quit
        }
        while (userChoice != 5);

    }
    //function to detect if sumValues is Prime
    public static boolean isPrime(int num)
    {
        // '1' is no prime
        if (num == 1)
        {
            return false;
        }
        for(int i = 2; i <= num/2; i++)
        {
            if(num%i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
