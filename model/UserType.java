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
     * */
    UserType (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
