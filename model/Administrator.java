package model;

/**
 * Created by Isabella on 10/1/16.
 */
public class Administrator extends AuthorizedUser {

    public Administrator(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public void deleteAccount() {
        // code
    }

    public void banUser() {
        // code
    }

    public void unblockAccount() {
        // code
    }

    public void viewSecurityLog() {
        // code
    }
}
