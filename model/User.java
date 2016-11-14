package model;

/**
 * @author Isabella Plonk, Shivani Upadhayay
 * @version 2.0
 */

public class User extends AuthorizedUser {

    public static String id;
    public static String title;

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

    /**
     * Getter method for name of Authorized User
     * @return name of Authorized User
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name of Authorized User
     * @param name String for name of Authorized User
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for username of Authorized User
     * @return username of Authorized User
     */
    public String getID() {
        return id;
    }

    /**
     * Setter method for username of Authorized User
     * @param id String for username of Authorized User
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Getter method for password of Authorized User
     * @return password of Authorized User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password of Authorized User
     * @param password String for password of Authorized User
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
