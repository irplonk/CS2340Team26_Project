package model;

/**
 * @author Isabella Plonk
 * @version 1.0
 */
public enum  OverallWaterCondition {
    SAFE("safe"),
    TREATABLE("treatable"),
    UNSAFE("unsafe");

    /** the representation of overall water condition */
    private String name;

    /**
     * Constructor for the enumeration
     *
     * @param name overall water condition
     */
    OverallWaterCondition(String name) {
        this.name = name;
    }

    /**
     * Getter method for String name of overall water condition
     * @return String name of overall water condition
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for String name of overall water condition
     * @param name String name of overall water condition
     */
    public void setName(String name) {
        this.name = name;
    }
}
