/**
 * This class represents a node of the binary search tree.
 *
 * Class: CS2210
 * Date: Nov 7 2023
 * @author James Wong
 */

public class BSTNode {

    /** Instance variable for the node */
    private Record item;

    /** Instance variable for the left child */
    private BSTNode leftChild;

    /** Instance variable for the right child */
    private BSTNode rightChild;

    /** Instance variable for the parent */
    private BSTNode parent;

    /**
     * BSTNode
     * @param item record item
     */
    public BSTNode(Record item) {
        this.item = item;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    /**
     * getRecord
     * @return record item
     */
    public Record getRecord() {
        return item;
    }

    /**
     * setRecord
     * @param d record item
     */
    public void setRecord(Record d) {
        item = d;
    }

    /**
     * getLeftChild
     * @return leftChild
     */
    public BSTNode getLeftChild() {
        return leftChild;
    }

    /**
     * getRightChild
     * @return rightChild
     */
    public BSTNode getRightChild() {
        return rightChild;
    }

    /**
     * getParent
     * @return parent
     */
    public BSTNode getParent(){
        return parent;
    }

    /**
     * setLeftChild
     * @param u new left child
     */
    public void setLeftChild(BSTNode u) {
        leftChild = u;
    }

    /**
     * setRightChild
     * @param u new right child
     */
    public void setRightChild(BSTNode u) {
        rightChild = u;
    }

    /**
     * setParent
     * @param u new parent
     */
    public void setParent(BSTNode u) {
        parent = u;
    }

    /**
     * isLeaf
     * @return true or false
     */
    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }
}
