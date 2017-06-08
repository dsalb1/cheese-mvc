package org.launchcode.models;

/**
 * Created by Dan on 6/7/2017.
 */
public enum CheeseType {
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    CheeseType (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
