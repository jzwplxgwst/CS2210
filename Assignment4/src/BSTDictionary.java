/**
 * the BSTDictionary class you must implement all the public methods specified in the BSTDictionaryADT
 *
 * Class: CS2210
 * Date: Nov 17 2023
 * @author James Wong
 */

public class BSTDictionary implements BSTDictionaryADT{

    // Instance variable to hold the BinarySearchTree
    private BinarySearchTree bst;

    /**
     * Constructs a new BSTDictionary by initializing the BinarySearchTree.
     */
    public BSTDictionary() {
        bst = new BinarySearchTree();   // create new BinarySearchTree instance
    }

    /* Returns the Record with key k, or null if the Record is not in the dictionary. */
    @Override
    public Record get(Key k) {
        // Retrieve the node with the given key from the BST
        BSTNode node = bst.get(bst.getRoot(), k);

        // Check if the node is null, and return the corresponding Record or null
        if (node == null) {
            return null;
        } else {
            return node.getRecord();
        }
    }

    /*
    /* Inserts d into the ordered dictionary. It throws a DictionaryException if a Record with the same Key as d is already in the dictionary. */
    @Override
    public void put(Record d) throws DictionaryException {
        // Get the key from the given Record
        Key key = d.getKey();

        // Check if a Record with the same key already exists in the dictionary
        if (bst.get(bst.getRoot(), key) != null) {
            throw new DictionaryException("Duplicate key: " + d.getKey());
        }
        bst.insert(bst.getRoot(), d);   // Insert the Record into the BST
    }

    /* Removes the Record with Key k from the dictionary. It throws a DictionaryException if the Record is not in the dictionary. */
    @Override
    public void remove(Key k) throws DictionaryException {
        bst.remove(bst.getRoot(), k);
    }

    /* Returns the successor of k (the Record from the ordered dictionary with
    smallest Key larger than k); it returns null if the given Key has no
    successor. The given Key DOES NOT need to be in the dictionary. */
    @Override
    public Record successor(Key k) {
        return bst.successor(bst.getRoot(), k).getRecord();
    }


    /* Returns the predecessor of k (the Record from the ordered dictionary with largest key smaller than k; it returns null if the given Key has no
    predecessor. The given Key DOES NOT need to be in the dictionary. */
    @Override
    public Record predecessor(Key k) {
        return bst.predecessor(bst.getRoot(), k).getRecord();
    }

    /* Returns the Record with smallest key in the ordered dictionary. Returns null if the dictionary is empty. */
    @Override
    public Record smallest() {
        return bst.smallest(bst.getRoot()).getRecord();
    }

    /* Returns the Record with largest key in the ordered dictionary. Returns null if the dictionary is empty. */
    @Override
    public Record largest() {
        return bst.largest(bst.getRoot()).getRecord();
    }
}
