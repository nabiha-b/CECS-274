// Author: Nabiha Bashir
// Stack Class

package CrazyTrain;

public class Stack {

    private Node top;

    //Constructor
    public Stack(){
        top = null;
    }

    //Push element to top of stack
    public void push(int n){
        Node temp = new Node (n);
        temp.setNext(top);
        top = temp;
    }

    //Remove element from top of stack
    public int pop(){
        int temp = top.getValue();
        top = top.getNext();
        return temp;
    }

    //Return value of element on top of stack
    public int top(){
        int temp = top.getValue();
        return temp;
    }

    //Check if stack is empty
    public boolean isEmpty(){
        if (top == null){
            return true;
        }
        else if (top != null){
            return false;
        }
        return false;
    }

}
