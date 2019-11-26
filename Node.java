
package binarysearchtree;

/**
 *
 * @author Alina Svarishchuk
 */
public class Node {
    
    //variables for left and right child of a node
    private Node leftChild;
    private Node rightChild;
    
    //variables to store node string and frequency
    private String nodeString;
    private int nodeFrequency;
   
    
    //node contructor
    public Node (String newString) {
        nodeString = newString;
        leftChild = rightChild = null;
        nodeFrequency = 1;
    
    }
    
    //method to return node frequency
    public int getFrequency () {
        return nodeFrequency;
    }
    
    //method to increase node frequency
    public void increaseFreq (){
        nodeFrequency ++;
    }
    
    //method to return string held by node
    public String getString () {
        return nodeString;
    }
    
    //method to return left child
    public Node getLeftChild () {
        return leftChild;
    }
    
    //method to return right child
    public Node getRightChild () {
        return rightChild;
    }
    
    //method to set left child
    public void setLeftChild (Node l) {
        leftChild = l;        
    }
    
    //method to set right child
    public void setRightChild (Node r) {
        rightChild = r;
    }
    
    
    public String toString () {
        return "" + nodeString;
    }
}

