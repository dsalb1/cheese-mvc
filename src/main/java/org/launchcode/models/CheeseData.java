package org.launchcode.models;

import java.util.ArrayList;

/**
 * Created by Dan on 6/5/2017.
 */
public class CheeseData {
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    //getAll
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }
    //addCheese
    public static void addCheese(Cheese newCheese) {
        cheeses.add(newCheese);
    }
    //removeCheese
    public static void removeCheese(int cheeseId) {
        Cheese cheeseToRemove = getById(cheeseId);
        cheeses.remove(cheeseToRemove);
    }

    //getById
    public static Cheese getById(int cheeseId) {
        Cheese theCheese = null;
        for (Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == cheeseId) {
                theCheese = candidateCheese;
            }
        }
        return theCheese;
    }
}
