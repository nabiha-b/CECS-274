// Author: Nabiha Bashir
// LinkedList Class

package LinkedList;

import java.util.Scanner;
import java.util.Random;

public class LinkedList {

    Node head;

    //-----Constructor-----
    public LinkedList() {
        head = null;
    }

    //-----Display linked list of nodes-----
    public void display() {
        Node temp = head;
        int i = 0;
        while (temp!= null) {

            //display nodes using 12 columns
            if ((i % 12 == 0) == false){
                temp.display();
                temp = temp.getNext();
            }
            else{
                System.out.println(" ");
                temp.display();
                temp = temp.getNext();
            }
            i++;
        }
    }


    //-----Add Node to front of list-----
    public void addToFront(String x) {
        Node temp = new Node(x);
        temp.setNext(head);
        head = temp;
    }

    //-----Return size of list-----
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    //-----Remove a node-----
    public boolean remove(int position) {
        Node curr = head;

        //remove head
        if(position == 0){
            head = curr.getNext();
            return true;
        }

        //remove node inside linked list
        int currIndex = 0;
        Node prev = head;
        curr = head.getNext();

        //transverse over list until desired index is reached
        while(curr!= null) {
            if (currIndex == position) {
                prev.setNext(curr.getNext());
                return true;
            }
            currIndex++;

            //unlink the deleted noted
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }

    //-----Find a node-----
    public boolean find(String x) {

        Node curr = head;
        while (curr != null) {
            if (curr.getValue().equals(x)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    //-----Add Nodes-----
    public void add(String x) {
        Node temp = new Node(x);

        //Case 1: Add to empty list
        if (head == null) {
            head = temp;
        }

        //Case 2: Add to front (temp < head)
        else if (temp.getValue().compareTo(head.getValue()) < 0) {
            temp.setNext(head);
            head = temp;
        }

        //Case 3: Add to end
        else {
            Node prev = null;
            Node curr = head;
            while (curr != null && temp.getValue().compareTo(head.getValue()) > 0 && temp.getValue().compareTo(curr.getValue()) > 0) {
                prev = curr;
                curr = curr.getNext();
            }

            //Case 4: Add inside
            prev.setNext(temp);
            temp.setNext(curr);
        }
    }

    //-----Create a random word------
    public static String createWord() {
        Random rand = new Random();
        char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char a1 = letter[rand.nextInt(letter.length)];
        char a2 = vowels[rand.nextInt(vowels.length)];
        char a3 = letter[rand.nextInt(letter.length)];
        char a4 = letter[rand.nextInt(letter.length)];

        String result = ("" + a1 + a2 + a3 + a4);
        return result;

    }

    //-----Find index of a given string------
    public int findIndex(String x){
        int index = 1;
        Node curr = head;
        while(curr!=null){
            if(curr.getValue() != null && curr.getValue().compareTo(x) == 0){
                return index;
            }
            index++;
            curr = curr.getNext();
        }
        return -1;
    }

    //-----Find the string of a given index-----
    public String findString(int index){
        Node curr = head;
        int counter = 0;
        while(curr!= null){
            if (counter == index){
                return curr.getValue();
            }
            curr = curr.getNext();
            counter++;
        }
        return "Invalid Index ";
    }


    //-----Main Function-----
    public static void main(String args[]) {

        //create a new linked list
        LinkedList myList = new LinkedList();


        //add 100 nodes to linked list
        for (int i = 0; i < 100; i++) {
            String x = createWord();
            myList.add(x);
        }
        String userInput;

        //Do-while loop to run the program until user Quits
        do {
            myList.display();

            //print menu and get user input
            System.out.println(" ");
            System.out.println("(A)dd, (D)elete, (F)ind, (Quit)  List Size:" + myList.size());
            Scanner in = new Scanner(System.in);
            System.out.println("> ");
            userInput = in.next();

            //if user chooses to Add a node
            if (userInput.equals("A")) {
                String newWord = createWord();
                myList.add(newWord);

                System.out.println(" ");
                System.out.println(newWord + " was added at location " + myList.findIndex(newWord));
                System.out.println(" ");
                System.out.println("---------------------------------------------------------");
            }

            //if user chooses to Delete a node
            else if (userInput.equals("D")) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(myList.size());
                String removedWord = myList.findString(randomIndex);
                myList.remove((randomIndex-1 ) );
                System.out.println(" ");

                System.out.println(removedWord + " was removed from location " + (randomIndex + 1));
                System.out.println(" ");
                System.out.println("(A)dd, (D)elete, (F)ind, (Quit)  List Size:" + myList.size());
                System.out.println("---------------------------------------------------------");

            }

            //if user chooses to Find a node
            else if (userInput.equals("F")) {
                System.out.println("Enter a word to find: ");
                String findWord = in.next();

                //check if entered word exists in linked list
                if (myList.find(findWord) == true) {
                    System.out.println(findWord + " found at location " + myList.findIndex(findWord));
                    System.out.println("---------------------------------------------------------");

                }
                else {
                    System.out.println(findWord + " not found.");
                    System.out.println("---------------------------------------------------------");
                }
            }

            //if user chooses to Quit, end program
            else if (userInput.equals("Q")) {
                System.out.println("You have chosen to exit. Goodbye!");
                System.out.println("---------------------------------------------------------");

            }

            //for incorrect input, repeat menu
            else{
                System.out.println("(A)dd, (D)elete, (F)ind, (Quit)  List Size:" + myList.size());
            }
        }
        while (userInput.equals("Q") == false);
    }
}



