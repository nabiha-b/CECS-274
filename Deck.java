

//Deck Class
package SolitairePrime;

import java.util.Random; //for shuffling cards

public class Deck {

    private Card [ ] storage; // make an array of cards
    private int top;          // the next card to deal

    //create a deck of 52 cards
    public Deck()
    {
        char[] suits = {'H', 'D', 'S', 'C'};
        char[] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
        top = 0;
        int x = 0;
        storage = new Card[52];

        //use for loops to create cards
        for (int s = 0; s < 4; s++)
        {
            for (int r = 0; r < 13; r++)
            {
                storage[x++] = new Card(ranks[r], suits[s]);
            }
        }
    }

    public void display()
    {
        int i = 0;
        System.out.println("Deck of Cards: ");
        while(i < storage.length)
        {
            storage[i].display();
            System.out.print(" ");
            i++;

            if(i%13 == 0)
            {
                System.out.println();
            }
        }
    }

    public void shuffle()
    {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++)
        {
            int x = rand.nextInt(52);
            int y = rand.nextInt(52);

            Card temp = storage[x];
            storage[x] = storage[y];
            storage[y] = temp;
        }
    }

    public Card deal()
    {
        return storage[top++];
    }

    public int cardsLeft()
    {
        int cardsLeft = 52 - top;
        return cardsLeft;
    }
}
