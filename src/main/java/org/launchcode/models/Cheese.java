package org.launchcode.models;

/**
 * Created by Dan on 5/21/2017.
 */
public class Cheese {
    private String name;
    private String description;
    private int cheeseId;
    private static int nextId =1;

    public Cheese(String name, String description) {
        this(); //call the default constructor for the given class
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
