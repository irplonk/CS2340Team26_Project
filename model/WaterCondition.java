package model;

import org.omg.PortableInterceptor.USER_EXCEPTION;

/**
 * Created by Shivani on 10/2/16.
 */
public enum WaterCondition {
    WASTE ("waste"),
    TREATABLE_CLEAR ("treatable-clear"),
    TREATABLE_MUDDY ("treatable-muddy"),
    POTABLE ("potable");

    /** the representation of the water condition */
    private String condition;

    /**
     * Constructor for the enumeration
     *
     * @param condition water condition
     * */
    WaterCondition (String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}