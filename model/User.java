package model;

/**
 * @author Isabella Plonk, Shivani Upadhayay
 * @version 2.0
 */

public class User extends AuthorizedUser {

    /**
     * Creates a User object
     */
    User() {

    }

    /**
     * Creates a User object
     * @param name String representation of the User name
     * @param id String representation of the User id
     * @param password String representation of the User password
     */
    public User(String name, String id, String password) {
        super(name, id, password);
    }
}
