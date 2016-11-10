package model;

/**
 * @author Isabella Plonk
 * @version 1.0
 */
public class Manager extends Worker {

    /**
     * No-args constructor for Manager object
     */
    public Manager() {
    }

    /**
     * Constructor for Manager object
     * @param name last name, first name of the Worker
     * @param id username of the Worker
     * @param password password of the Worker
     */
    public Manager(String name, String id, String password) {
        super(name, id, password);
    }
}
