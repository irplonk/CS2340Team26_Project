package src.main.java.model;

/**
 * Created by Shivani on 10/2/16.
 */
//Bottled, Well, Stream, Lake, Spring, Other
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