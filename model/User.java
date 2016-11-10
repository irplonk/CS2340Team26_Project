package model;

/**
 * Created by Isabella on 10/1/16.
 * Edited by Shivani on 10/3/16.
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
