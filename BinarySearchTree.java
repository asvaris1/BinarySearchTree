
package binarysearchtree;

/**
 *
 * @author Alina Svarishchuk
 */
public class BinarySearchTree {

    //instantiate a root for the tree and the tree size
    private Node root;
    private int size;

    //Constructor for a binary tree
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    //check to see if binary tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    //method to insert a string into the tree
    public void insert(String p) {

        //wrap the string in a node
        Node n = new Node(p);
        
        //If the tree is empty, put the object at the root
        if (isEmpty()) {
            root = n;
        } else {
            
            //call insert method to compare new node to the root
            insert(root, n);
        }
    }

    //method to insert a node based on alphabetical order
    void insert(Node subRoot, Node p) {

        //Determine whether p should go left or right
        //Check to see if the new node is equal to the root
        if (p.getString().compareToIgnoreCase(subRoot.getString()) == 0) {
            
            //if the strings are equivalent, increase the frequency of the node
            subRoot.increaseFreq();

        } 
        
        //check to see if the string comes before or after in the alphabet
        else if (p.getString().compareToIgnoreCase(subRoot.getString()) < 0) {     //Left

            //Is there a left child already
            if (subRoot.getLeftChild() == null) {
                //Put p as root's left child
                subRoot.setLeftChild(p);
            } else {
                //Recursively call insert on the left child
                insert(subRoot.getLeftChild(), p);
            }
        } else {                                           //Right

            //Is there a right child already
            if (subRoot.getRightChild() == null) {
                //Put p as root's right child
                subRoot.setRightChild(p);
            } else {
                //Recursively call insert on the right child
                insert(subRoot.getRightChild(), p);
            }
        }
    }

    public Node search(String c) {
        //Searching for a Node with string equal to c

        //Make sure the tree is not empty
        if (isEmpty()) {
            return null;
        }

        //run recursive method for searching 
        return search(root, c);
    }

    Node search(Node subroot, String c) {

        //Check to see if the strings match
        if (c.equals(subroot.getString())) {
            
            //if the strings match, print the value of the node
            System.out.println(subroot.toString());
            return subroot;
        } 
        
        //compare alphabetical order of the strings
        else if (c.compareToIgnoreCase(subroot.getString()) < 0) {   

            //Is there a left child
            if (null == subroot.getLeftChild()) {
                
                //if there is no left child, there is no match
                return null;
            } else {
                
                
                //run rescursive search method with the left child as the new subroot
                return search(subroot.getLeftChild(), c);
            }

        } else {                                    //Right

            //Is there a right child
            if (subroot.getRightChild() == null) {
                
                //if there is no right child, there is no match
                return null;
            } else {
                
                //run rescursive search method with the right child as the new subroot
                return search(subroot.getRightChild(), c);
            }

        }

    }

    //method to print preorder traversal
    public void printPreOrder() {

        System.out.println("Running PreOrder Traversal");
        printPreOrder(root);
    }

    void printPreOrder(Node subroot) {
        
        //make sure the tree is not empty
        if (subroot == null) {
            return;
        }

        //Print subroot
        System.out.println(subroot.toString());

        //Left subtree
        printPreOrder(subroot.getLeftChild());

        //Right subtree
        printPreOrder(subroot.getRightChild());
    }

    //method to print inorder traversal
    public void printInOrder() {

        System.out.println("Running InOrder Traversal");
        printInOrder(root);
    }

    void printInOrder(Node subroot) {
        
        //make sure the tree is not empty
        if (subroot == null) {
            return;
        }

        //Left subtree
        printInOrder(subroot.getLeftChild());

        //Print subroot
        System.out.println(subroot.toString());

        //Right subtree
        printInOrder(subroot.getRightChild());
    }

    //method to print postorder traversal
    public void printPostOrder() {

        System.out.println("Running PostOrder Traversal");
        printPostOrder(root);
    }

    void printPostOrder(Node subroot) {
        
        //make sure the tree is not empty
        if (subroot == null) {
            return;
        }

        //Left subtree
        printPostOrder(subroot.getLeftChild());

        //Right subtree
        printPostOrder(subroot.getRightChild());

        //Print subroot
        System.out.println(subroot.toString());

    }
}
