
package model;

/**
 * Created by Isabella on 10/1/16.
 */
public class User extends AuthorizedUser {

    protected enum waterType;
    protected enum waterCondition;
    protected static int counter = 0;
    protected int num = 0;

    public User(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public void submitReport(waterCondition, waterType) {
        // the number of the report
        counter++;
        num = counter;
    }

    public void viewWaterSources() {
        // code
        //viewMap();
    }
}
