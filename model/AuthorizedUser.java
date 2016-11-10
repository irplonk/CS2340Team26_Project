package model;

/**
 * @author Isabella Plonk, Shivani Upadhayay
 * @version 2.0
 */
public abstract class AuthorizedUser {
    String name;
    String id;
    String password;
    private String emailaddress;
    private String homeaddress;
    private String title;

    /**
     * No args constructor
     */
    AuthorizedUser() {
    }

    /**
     * Sets name, id, and password of AuthorizedUser
     * @param name String representation of AuthorizedUser name
     * @param id String representation of AuthorizedUser id
     * @param password String representation of AuthorizedUser password
     */
    AuthorizedUser(String name, String id, String password) {
        this.name = name;
        this.password = password;
        this.id = id;
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

    /**
     * Setter method for email address of Authorized User
     * @param emailaddress String for email address of Authorized User
     */
    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    /**
     * Getter method for email address of Authorized User
     * @return email address of Authorized User
     */
    public String getEmailaddress() {
        return emailaddress;
    }

    /**
     * Setter method for home address of Authorized User
     * @param homeaddress String for home address of Authorized User
     */
    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    /**
     * Getter method for home address of Authorized User
     * @return home address of Authorized User
     */
    public String getHomeaddress() {
        return homeaddress;
    }

    /**
     * Setter method for title of Authorized User
     * @param title String for title of Authorized User
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for title of Authorized User
     * @return title of Authorized User
     */
    public String getTitle() {
        return title;
    }

}

