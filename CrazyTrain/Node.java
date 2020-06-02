// Author: Nabiha Bashir
// Node Class

package CrazyTrain;

public class Node {

    //initialize and create
    private int value;
    private Node next;

        //Constructor
        public Node(int v){
            value = v;
            next = null;
        }

        //Return value of Node
        public int getValue(){
            return value;
        }

        //Set value to next node
        public void setNext(Node nextNode) {
            next = nextNode;
        }

        //Get next Node
        public Node getNext() {
            return next;
        }

        //Set value of current node
        public void setValue(int x){
            value = x;
        }

        //Display node
        public void display(){
            System.out.print(value + " ");
        }
}
