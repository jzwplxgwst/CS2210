/**
 * This class represents the records to be stored in the internal nodes of the binary search tree.
 *
 * Class: CS2210
 * Date: Nov 7 2023
 * @author James Wong
 */

public class Record {

    /** Instance variable Key key */
    private Key key;

    /** Instance variable String data */
    private String data;

    /**
     * Record
     * @param k key
     * @param theData data
     */
    public Record(Key k, String theData) {
        this.key = k;
        this.data = theData;
    }

    /**
     * getKey
     * @return this.key
     */
    public Key getKey() {
        return this.key;
    }

    /**
     * getDataItem
     * @return this.data
     */
    public String getDataItem() {
        return this.data;
    }
}
