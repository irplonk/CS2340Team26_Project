package model;

import org.omg.PortableInterceptor.USER_EXCEPTION;

/**
 * Created by Isabella on 10/1/16.
 */
public enum UserType {
    USER ("user"),
    WORKER("worker"),
    MANAGER("manager"),
    ADMINISTRATOR("adminsitrator");

    /** the representation of the user type */
    private String name;

    /**
     * Constructor for the enumeration
     *
     * @param name user type
     */
    UserType (String name) {
        this.name = name;
    }

    /**
     * Getter method for String name of user type
     * @return String name of user type
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for String name of user type
     * @param name String name of user type
     */
    public void setName(String name) {
        this.name = name;
    }

}
