package model;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Created by Isabella on 10/1/16.
 * Edited by Shivani on 10/3/16.
 */

public class User extends AuthorizedUser {

    /**
     * Creates a User object
     */
    public User() {

    }

    /**
     * Creates a User object
     * @param name String representation of
     * @param id
     * @param password
     */
    public User(String name, String id, String password) {
        super(name, id, password);
    }
}
