package model;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Shivani on 10/3/16.
 */

public class User extends AuthorizedUser {
    protected enum WaterType;
    protected enum WaterCondition;
    protected static int counter = 0;
    protected int num = 0;

    public User(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public void submitReport(WaterType, WaterCondition) {
        // code
        this.WaterType = WaterType;
        this.WaterCondition = WaterCondition;
        counter++;
        num = counter;
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        System.out.println(df.format(calobj.getTime()));
    }

    public void viewWaterSources() {
        // code
    }
}
