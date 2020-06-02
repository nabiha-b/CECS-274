package SolitairePrime;

public class Card {

    private char suit;
    private char rank;

    public Card(char r, char s)
    {
        rank = r;
        suit = s;
    }

    //function to display card with 2 characters (rank, suit)
    public void display()
    {
        if(rank != 'T')
        {
            System.out.print((rank+"")+(suit+""));
        }

        //display '10' instead 'T'
        else
        {
            System.out.print("10"+(suit+""));
        }
    }

    //function to assign values to ranks
    public int getValue()
    {
        int value = 0;

        if (rank == 'A')
            value = 1;

        else if (rank == '2')
            value = 2;

        else if (rank == '3')
            value = 3;

        else if (rank == '4')
            value = 4;

        else if (rank == '5')
            value = 5;

        else if (rank == '6')
            value = 6;

        else if (rank == '7')
            value = 7;

        else if (rank == '8')
            value = 8;

        else if (rank == '9')
            value = 9;

        else if (rank == 't')
            value = 10;

        else if (rank == 'J')
            value = 10;

        else if (rank == 'Q')
            value = 10;

        else if (rank == 'K')
            value = 10;

        return value;
    }

    //returns rank of card (1-10)
    public char getRank()
    {
        return rank;
    }

    //returns suit of card (S,D,H,C)
    public char getSuit()
    {
        return suit;
    }
}
