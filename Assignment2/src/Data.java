/**
 * This will be the class data
 *
 * Class: CS2210
 * Date: Oct 13 2023
 * @author James Wong
 */

public class Data {
    /** The specified string configuration */
    private String config;

    /** The specified int score */
    private int score;

    /**
     * Name: Data
     * @param config board configuration
     * @param score score
     */
    public Data(String config, int score) {
        this.config = config;
        this.score = score;
    }

    /**
     * Name: getConfiguration
     * @return the board configuration stored in this Data object
     */
    public String getConfiguration() {
        return this.config;
    }

    /**
     * Name: getScore
     * @return the score in this Data
     */
    public int getScore() {
        return this.score;
    }
}
