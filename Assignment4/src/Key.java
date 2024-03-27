/**
 * This class represents the key of the data items stored in the internal nodes of the binary search
 * tree implementing the ordered dictionary
 *
 * Class: CS2210
 * Date: Nov 7 2023
 * @author James Wong
 */

public class Key {

    /** Instance variable label */
    private String
            theLabel;

    /** Instance variable type */
    private int theType;

    /**
     * Key
     * @param theLabel label
     * @param theType type
     */
    public Key(String theLabel, int theType){
        this.theLabel = theLabel.toLowerCase();
        this.theType = theType;
    }

    /**
     * getLabel
     * @return this.theLabel
     */
    public String getLabel() {
        return this.theLabel;
    }

    /**
     * getType
     * @return this.theType
     */
    public int getType() {
        return this.theType;
    }

    /**
     * compareTo
     * @param k key
     * @return 1, -1, or 0
     */
    public int compareTo(Key k) {
        // Compare the label attribute of the two keys
        if (this.getLabel().compareTo(k.getLabel()) > 0) {
            return 1;   // This Key is greater
        } else if (this.getLabel().compareTo(k.getLabel()) < 0) {
            return -1;  // This Key is smaller
        } else {
            // If labels are equal, compare the type attribute
            if (this.getType() > k.getType()) {
                return 1;   // This Key is greater
            } else if (this.getType() < k.getType()) {
                return -1;  // This Key is smaller
            } else {
                return 0; // Both Key objects are equal
            }
        }
    }
}
