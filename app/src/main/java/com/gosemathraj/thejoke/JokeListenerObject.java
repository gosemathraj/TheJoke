package com.gosemathraj.thejoke;

/**
 * Created by iamsparsh on 27/1/17.
 */

public class JokeListenerObject {

    private int category;
    private JokeListener jokeListener;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public JokeListener getJokeListener() {
        return jokeListener;
    }

    public void setJokeListener(JokeListener jokeListener) {
        this.jokeListener = jokeListener;
    }
}
