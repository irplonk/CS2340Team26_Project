package model;


/**
 * @author Shivani Upadhayay
 * @version 1.0
 */
public enum WaterType {
    BOTTLED ("bottled"),
    WELL ("well"),
    STREAM ("stream"),
    LAKE ("lake"),
    SPRING ("spring"),
    OTHER("other");
    /** the representation of the water type */
    private String type;

    /**
     * Constructor for the enumeration
     *
     * @param type water type
     * */
    WaterType (String type) {
        this.type = type;
    }

    /**
     * Getter for water type
     * @return String representation of water type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for water type
     * @param type String name of water type
     */
    public void setType(String type) {
        this.type = type;
    }

}