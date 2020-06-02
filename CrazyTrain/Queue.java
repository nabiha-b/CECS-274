// Author: Nabiha Bashir
// Queue Class

package CrazyTrain;

public class Queue {

    //initialize and create
    private Node front;
    private Node back;


    //Constructor
    public Queue(){
        front = null;
    }

    //Check if queue is empty
    public boolean isEmpty(){
        return front == null;
    }

    //Enqueue: add to back
    public void enQueue(int x) {
        Node temp = new Node(x);
        Node curr = front;
        if(front == null){
            front = temp;
        }
        else{
            while(curr.getNext() != null){
                curr = curr.getNext();
            }
            curr.setNext(temp);
        }
    }

    //Dequeue: remove from front
    public int deque(){
        int temp = front.getValue();
        front = front.getNext();
        return temp;
    }

    //Return front value
    public int front(){
        int temp = front.getValue();
        return temp;
    }

    //Display queue
    public void display() {
        Node temp = front;
        int i = 0;
        while (temp!= null) {

            //display nodes using 12 columns
            if (temp.getNext() != null){
                temp.display();
                System.out.print("- ");
                temp = temp.getNext();
            }
            else{
                temp.display();
                temp = temp.getNext();
            }
            i++;
        }
    }
}


