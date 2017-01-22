package com.gosemathraj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iamsparsh on 18/1/17.
 */

public class Jokes {

    private ArrayList<String> jokesList;

    public Jokes() {
        jokesList = new ArrayList<>();
    }

    public ArrayList<String> getJokesList() {
        return jokesList;
    }

    public void setJokesList(ArrayList<String> jokesList) {
        this.jokesList = jokesList;
    }
}
