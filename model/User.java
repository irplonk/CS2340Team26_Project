package model;

/**
 * Created by Isabella on 10/1/16.
 */
public class User extends AuthorizedUser {

    /**
     * Constructor for User object
     * @param name last name, first name of the Worker
     * @param id username of the Worker
     * @param password password of the Worker
     */
    public User(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public void submitReport() {
        // code
    }

    public void viewWaterSources() {
        // code
    }
}
