package model;

/**
 * @author Isabella Plonk
 * @version 1.0
 */
public class Administrator extends AuthorizedUser {

    /**
     * No-args constructor for Administrator object
     */
    public Administrator() {
    }

    /**
     * Constructor for Administrator object
     * @param name String representation of Administrator name
     * @param id String representation of Administrator id
     * @param password String representation of Administrator password
     */
    public Administrator(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }
}
