package model;

/**
 * Created by Isabella on 10/1/16.
 */
public abstract class AuthorizedUser {
    protected String name;
    protected String id;
    protected String password;

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

