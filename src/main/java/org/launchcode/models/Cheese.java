package org.launchcode.models;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * Created by Dan on 5/21/2017.
 */
public class Cheese {

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;

    @Min(1)
    @Max(5)
    private int rating;

    private CheeseType type;

    private int cheeseId;
    private static int nextId = 0;

    public Cheese(String name, String description) {
        this(); //call the default constructor for the given class
        this.name = name;
        this.description = description;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
