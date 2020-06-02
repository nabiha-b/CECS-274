// Author: Nabiha Bashir
// BST Class

package BinarySearchTree;
import java.util.Scanner;

public class BST {
    //embed the Node class within the BST class
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int x) {
            value = x;
            left = null;
            right = null;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    } //end class Node

    //root of the tree
    private Node root;

    //default constructor
    public BST() {
        root = null;
    }

    //get the root of the entire tree
    public int getRoot() {
        return root.getValue();
    }

    //get the count of items in the tree
    public int getCount() {
        return getCount(root);
    }

    //private function to get the count of items in a subtree
    private int getCount(Node N) {
        if (N == null){
            return 0;
        }
        else{
            int count = 1;
            count += getCount(N.getLeft());
            count += getCount(N.getRight());
            return count;
        }
    }

    //add an integer x to the entire tree
    public void add(int x) {
        if (root == null) {
            root = new Node(x);
        } else {
            add(root, x);
        }
    }

    //add a node N to the subtree P
    private boolean add(Node N, int x) {
        if (x == N.value) {
            return false;
        }
        else {
            if (x < N.value) {
                if (N.left == null) {
                    N.left = new Node(x);
                    return true;
                }
                else {
                    return add(N.left, x);
                }
            }
            else {
                //x is greater
                if (N.right == null) {
                    N.right = new Node(x);
                    return true;
                } else {
                    return add(N.right, x);
                }
            }
        }
    }


    //print the contents of the entire tree in order
    public void print() {
        print(root);
    }

    //print the contents of a subtree in order
    public void print(Node n) {
        if (n == null) {
            return;
        } else {
            print(n.left);
            System.out.print(n.value + ", ");
            print(n.right);
        }
    }

    //get the height of the entire tree
    public int getHeight() {
        return getHeight(root);
    }

    //get the height of the subtree N
    private int getHeight(Node N) {
        if (N == null){
            return 0;
        }
        else{
            return (1 + Math.max(getHeight(N.left),getHeight(N.right)));
        }
    }


    //return true if BST is empty
    public boolean isEmpty(){
        return root == null;
    }


    //helper function to find minimum value node in subtree rooted at curr
    public Node minimumKey(Node curr) {
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    //remove integer x from the entire tree
    public boolean remove(int x) {
        return remove(root, x);
    }

    //remove Node key from subtree
    private boolean remove(Node root, int key) {
        //pointer to store parent node of current node
        Node parent = null;

        //start with root node
        Node curr = root;

        //search key in BST and set its parent pointer
        while (curr != null && curr.value != key){
            //update parent node as current node
            parent = curr;
            //if given key is less than the current node, go to left subtree
            if (key < curr.value){
                curr = curr.left;
            }
            //else go to right subtree
            else{
                curr = curr.right;
            }
        }
        //return false if key is not found in the tree
        if (curr == null){
            return false;
        }
        //Case 1: node to be deleted has no children i.e. it's a leaf node
        if (curr.right == null && curr.left == null){
            //if node to be detected is not a root node, then set its parent left/right child to null
            if (curr != root){
                if (parent.left == curr) {
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            //if tree has only root node, delete it and set root to null
            else{
              root = null;
            }
        }
        //Case 2: node to be deleted has two children
        else if(curr.left != null && curr.right != null){
            //find its in-order successor node
            Node successor = minimumKey(curr.right);
            //store successor value
            int val = successor.value;
            //recursively delete the successor; note that successor will have at-most 1 child (right child)
            remove (root,successor.value);
            //copy the value of successor to current node
            curr.value = val;
        }
        //Case 3: node to be deleted has only one child
        else{
            //find child node
            Node child = (curr.left != null)? curr.left: curr.right;
            //if node to be deleted is not a root node, then set its parent to its child
            if (curr != root){
                if (curr == parent.left){
                    parent.left = child;
                }
                else{
                    parent.right = child;
                }
            }
            //if node to be deleted is root node, then set the root to child
            else{
                root = child;
            }
        }
        return true;
    }

    //function to display the top 5 levels of the tree
    public void display() {
        String[] A = new String[32];
        for (int i = 0; i < 32; i++) {
            A[i] = " . ";
        }
        String temp;
        if (root == null) {
            temp = " . ";
        } else {
            temp = Integer.toString(root.value);
        }
        A[1] = temp;

        buildArray(root, A, 1);

        //display BST
        System.out.println("                                                                               ");
        System.out.println("                                                    "+A[1]+"                   ");
        System.out.println("                                                     |                         ");
        System.out.println("                         "+A[2]+"-------------------------^-------------------------"+A[3]);
        System.out.println("                          |                                                     |  ");
        System.out.println("            "+A[4]+"-----------^-----------"+A[5]+"                         "+A[6]+"-----------^-----------"+A[7]);
        System.out.println("             |                         |                           |                         |            ");
        System.out.println("      "+A[8]+"----^----"+A[9]+"           "+A[10]+"----^----"+A[11]+"             "+A[12]+"----^----"+A[13]+"           "+A[14]+"----^----"+A[15]);
        System.out.println("       |           |             |           |               |           |             |           |    ");
        System.out.println("   "+A[16]+"-^-"+A[17]+"   "+A[18]+"-^-"+A[19]+"     "+A[20]+"-^-"+A[21]+"   "+A[22]+"-^-"+A[23]+"       "+A[24]+"-^-"+A[25]+"   "+A[26]+"-^-"+A[27]+"     "+A[28]+"-^-"+A[29]+"   "+A[30]+"-^-"+A[31]);
        System.out.println("                                                                               ");

    }



    private void buildArray(Node n, String [] strArray, int parentIndex){
        if (parentIndex * 2 + 1 > strArray.length){
            return;
        }
        if (n == null){
            return;
        }
        else{
            String temp;
            if (n.left == null){
                temp = " . ";
            }
            else{
                temp = Integer.toString(n.left.value);
            }
            strArray[parentIndex*2] = String.format("%3s", temp);
            buildArray(n.left, strArray, parentIndex*2);

            if(n.right == null){
                temp = " . ";
            }
            else{
                temp = Integer.toString(n.right.value);
            }
            strArray[parentIndex*2+1] = String.format("%3s", temp);
            buildArray(n.right, strArray, parentIndex*2+1);
        }

    }




public static void main (String[] args){
    Scanner in = new Scanner (System.in);
    BST bst = new BST();
    String choice;

    do {
        //display tree
        bst.display();

        //display contents of tree
        if (bst.root == null){
            System.out.println("Empty List");
        }
        else{
            bst.print(bst.root);
        }

        System.out.println();
        System.out.println("Tree Height: " + bst.getHeight());

        //print root
        if (bst.root == null) {
            System.out.println("No root: Tree is empty");
        }
        else {
            System.out.println("Tree Root: " + bst.getRoot());
        }

        System.out.println("Tree Count: " + bst.getCount());
        System.out.println("(A)dd item  (R)emove item  (E)mpty tree  (D)efault tree  (Q)uit");
        System.out.println("Enter Choice: ");
        choice = in.next();

        if (choice.equals("A") || choice.equals("a")) {
            System.out.println("Enter integer to add to tree: ");
            int addInt = in.nextInt();
            bst.add(addInt);

        }
        else if (choice.equals("R") || choice.equals("r")) {
            System.out.println("Enter integer to remove from tree: ");
            int removeInt = in.nextInt();
            bst.remove(removeInt);
            System.out.println(removeInt + " was removed from tree.");

        }
        else if (choice.equals("E") || choice.equals("e")) {
            bst = new BST();
        }

        else if (choice.equals("D") || choice.equals("d")) {
            bst = new BST();
            bst.add(500);
            bst.add(205);
            bst.add(150);
            bst.add(120);
            bst.add(102);
            bst.add(134);
            bst.add(187);
            bst.add(169);
            bst.add(201);
            bst.add(250);
            bst.add(230);
            bst.add(210);
            bst.add(235);
            bst.add(402);
            bst.add(263);
            bst.add(410);
            bst.add(750);
            bst.add(604);
            bst.add(570);
            bst.add(562);
            bst.add(583);
            bst.add(691);
            bst.add(621);
            bst.add(699);
            bst.add(834);
            bst.add(794);
            bst.add(775);
            bst.add(799);
            bst.add(925);
            bst.add(852);
            bst.add(960);

        }
        else if (choice.equals("Q") || choice.equals("q")) {
            System.out.println("You have chosen to quit. Goodbye!");
        }
    }
    while (choice.equals("Q") == false && choice.equals("q") == false);
}
}


