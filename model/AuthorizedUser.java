package model;

/**
 * Created by Isabella on 10/1/16.
 */
public abstract class AuthorizedUser {
    protected String name;
    protected String id;
    protected String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

