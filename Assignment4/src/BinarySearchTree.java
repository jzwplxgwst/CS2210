/**
 * This class represents a binary search tree
 *
 * Class: CS2210
 * Date: Nov 7 2023
 * @author James Wong
 */

public class BinarySearchTree {

    /** Instance variable for root */
    private BSTNode root;

    /** Constructs an empty Binary Search Tree by initializing the root to null */
    public BinarySearchTree(){
        root = null;
    }

    /**
     * Returns the root node of this binary search tree
     * @return this.root
     */
    public BSTNode getRoot() {
        return this.root;
    }

    /**
     * Returns the node storing the given key; returns null if the key is not stored in the tree with root r
     * @param r root node
     * @param k key node in the binary search tree
     * @return the node storing the given key
     */
    public BSTNode get(BSTNode r, Key k) {
        // Check for null root or null key, indicating an empty tree or an invalid key
        if (r == null || k == null) {
            return null;
        }

        // Compare the key of the current node with the search key
        if (k.compareTo(r.getRecord().getKey()) == 0) {
            // If the keys match, return the current node
            return r;
        } else if (k.compareTo(r.getRecord().getKey()) < 0) {
            // If the search key is smaller, recursively search in the left subtree
            return get(r.getLeftChild(), k);
        } else {
            // If the search key is larger, recursively search in the right subtree
            return get(r.getRightChild(), k);
        }
    }

    /**
     * Adds the record to the binary search tree with root r. Throws a DictionaryException if the tree already stores a record with the same key as d.
     * @param r root
     * @param record of the binary search tree
     * @throws DictionaryException if there are duplicate keys
     */
    public void insert(BSTNode r, Record record) throws DictionaryException {
        if (root == null) {
            // If the tree is empty, create a new node with the given record
            root = new BSTNode(record);
        } else {
            // Compare the keys of the records
            int compare = record.getKey().compareTo(r.getRecord().getKey());
            BSTNode c = new BSTNode(record);

            if (compare < 0) {
                // If the new record's key is smaller, insert into the left subtree
                if (r.getLeftChild() == null) {
                    r.setLeftChild(c);
                    c.setParent(r);
                } else {
                    insert(r.getLeftChild(), record);
                }

            } else if (compare > 0) {
                // If the new record's key is larger, insert into the right subtree
                if (r.getRightChild() == null) {
                    r.setRightChild(c);
                    c.setParent(r);
                } else {
                    insert(r.getRightChild(), record);
                }

            } else {
                // Duplicate key found, throw an exception
                throw new DictionaryException("Duplicate key: " + record.getKey());
            }
        }
    }

    /**
     * Deletes the node with the given key from the tree with root r.
     * Throws a DictionaryException if the tree does not store a record with the given key
     * @param r root
     * @param k key node
     */
    public void remove(BSTNode r, Key k) throws DictionaryException {
        BSTNode current = get(r, k);    // Find the node with the given key in the binary search tree

        // If the node is the root, set the root to null
        if (current == null){
            throw new DictionaryException("Key is not found in the BST");
        }

        // If the node is the root, set the root to null
        if (current.isLeaf()) {
            BSTNode parent = current.getParent();
            if (parent == null){
                root = null;
            } else if (parent.getLeftChild() == current) {
                parent.setLeftChild(null);

            } else if (parent.getRightChild() == current) {
                parent.setRightChild(null);

            }
            current.setParent(null);

        } else if (current.getLeftChild() == null) {
            // If the node has only a right child, replace it with the right child
            removeHelper(r, current, current.getRightChild());
        } else if (current.getRightChild() == null) {
            // If the node has only a left child, replace it with the left child
            removeHelper(r, current, current.getLeftChild());
        } else {
            // If the node has both left and right children, find the smallest node in the right subtree
            BSTNode smallest = smallest(current.getRightChild());

            if (smallest.getParent() != current) {
                removeHelper(r, smallest, smallest.getRightChild());
                smallest.setRightChild(current.getRightChild());
                smallest.getLeftChild().setParent(smallest);
            }
        }
    }


    /**
     * Returns the node storing the successor of the given key in the tree with root r;
     * returns null if the successor does not exist.
     * @param r root
     * @param k key node
     * @return parent, smallest(current.getRightChild()) or null
     */
    public BSTNode successor(BSTNode r, Key k) {
        // Find the node with the given key in the binary search tree
        BSTNode current = get(r, k);

        // If the node with the key is not found, there is no successor
        if (current == null) {
            return null;
        }

        // If the node has a right child, the successor is the smallest node in the right subtree
        if (current.getRightChild() != null) {
            return smallest(current.getRightChild());
        }

        // If the node has no right child, traverse up the tree to find the successor
        BSTNode parent = current.getParent();
        while (parent != null && current == parent.getRightChild()) {
            current = parent;
            parent = parent.getParent();
        }

        // Return the parent node as the successor, or null if no successor found
        return parent;
    }

    /**
     * Returns the node storing the predecessor of the given key in the tree with root r;
     * returns null if the predecessor does not exist
     * @param r root
     * @param k key node
     * @return parent, current or null
     */
    public BSTNode predecessor(BSTNode r, Key k) {// Find the node with the given key in the binary search tree

        BSTNode current = get(r, k);

        // If the node with the key is not found, there is no predecessor
        if (current == null) {
            return null;
        }

        // If the node has a left child, the predecessor is the largest node in the left subtree
        if (current.getLeftChild() != null) {
            return largest(current.getLeftChild());
        }

        // If the node has no left child, traverse up the tree to find the predecessor
        BSTNode parent = current.getParent();
        while (parent != null && current == parent.getLeftChild()) {
            current = parent;
            parent = parent.getParent();
        }

        // Return the parent node as the predecessor, or null if no predecessor found
        return parent;
    }

    /**
     * Returns the node with the smallest key in tree with root r.
     * @param r root
     * @return curRoot
     */
    public BSTNode smallest(BSTNode r) {
        // Initialize the current root node to the given root
        BSTNode curRoot = r;

        // If the tree is empty, return null
        if (curRoot == null) {
            return null;
        } else {
            // Traverse to the leftmost child to find the node with the smallest key
            while (curRoot.getLeftChild() != null) {
                curRoot = curRoot.getLeftChild();
            }
        }
        // Return the node with the smallest key
        return curRoot;
    }

    /**
     * Returns the node with the largest key in tree with root r.
     * @param r root
     * @return curRoot
     */
    public BSTNode largest(BSTNode r) {
        // Initialize the current root node to the given root
        BSTNode curRoot = r;

        // If the tree is empty, return null
        if (curRoot == null) {
            return null;
        } else {
            // Traverse to the rightmost child to find the node with the largest key
            while (curRoot.getRightChild() != null) {
                curRoot = curRoot.getRightChild();
            }
        }
        // Return the node with the largest key
        return curRoot;
    }

    /**
     * deleting a node with two children
     * replaces one subtree with another
     * @param r root
     * @param current node
     * @param child child of the node
     */
    private void removeHelper(BSTNode r, BSTNode current, BSTNode child) {
        // If the node to be removed is the root
        if (current.getParent() == null) {
            // Set the child as the new root, and update its parent reference
            root = child;
            if (child != null) {
                child.setParent(null);
            }
        } else if (current == current.getParent().getLeftChild()) {
            // If the node to be removed is a left child
            current.getParent().setLeftChild(child);
        } else {
            // If the node to be removed is a right child
            current.getParent().setRightChild(child);
        }

        // Update the parent reference of the replacement child
        if (child != null) {
            child.setParent(current.getParent());
        }
    }
}