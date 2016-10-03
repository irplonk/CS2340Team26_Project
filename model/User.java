package model;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
package com.gpstracker;
/**
 * Created by Shivani on 10/3/16.
 */

public class User extends AuthorizedUser {
    protected enum WaterType;
    protected enum WaterCondition;
    protected static int counter = 0;
    protected int num = 0;
    protected String emailaddress;
    protected String homeaddress;
    protected String title;

    public User(String name, String id, String password, String emailaddress, String homeaddress, String title) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.emailaddress = emailaddress;
        this.homeaddress = homeaddress;
        this.title = title;
    }

    public void submitReport(WaterType, WaterCondition) {
        // code
        this.WaterType = WaterType;
        this.WaterCondition = WaterCondition;
        counter++;
        num = counter;
        //PositionService positionService = PlatformFactory.getPlatform().getPositionService();
        //Position position = positionService.getPosition();
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        System.out.println(df.format(calobj.getTime()));
        //System.out.println("Current GPS position: " + position.getLatitude() + "," + position.getLongitude());
    }

    public void viewWaterSources() {
        // code
    }
}
