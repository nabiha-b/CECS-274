// Author: Nabiha Bashir
// Node Class

package LinkedList;

public class Node {
    private String value;  //initialize and create private integer value
    private Node next;

    //-----Constructor-----
    public Node(String v){
        value = v;
        next = null;
    }

    //-----returns value of node-----
    public String getValue(){

        return value;
    }

    //-----return next node-----
    public Node getNode(){

        return next;
    }

    //-----reference next node-----
    public void setNext(Node nextNode) {

        next = nextNode;
    }

    //-----get next Node-----
    public Node getNext() {
        return next;
    }

    //-----set value of next node-----
    public void setValue(String x){

        value = x;
    }

    //-----display node-----
    public void display(){

        System.out.print(value + " ");
    }

}
