package model;

/**
 * Created by Isabella on 10/1/16.
 */
public class Worker extends User {

    /**
     * Constructor for Worker object
     * @param name last name, first name of the Worker
     * @param id username of the Worker
     * @param password password of the Worker
     */
    public Worker(String name, String id, String password) {
        super(name, id, password);
    }

    public void reportWaterPurity() {
        //
    }
}
