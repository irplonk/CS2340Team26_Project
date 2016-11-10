package model;

/**
 * @author Isabella Plonk
 * @version 1.0
 */
public class Worker extends User {

    /**
     * No-args constructor for Worker object
     */
    Worker() {
    }

    /**
     * Constructor for Worker object
     * @param name last name, first name of the Worker
     * @param id username of the Worker
     * @param password password of the Worker
     */
    public Worker(String name, String id, String password) {
        super(name, id, password);
    }

}
