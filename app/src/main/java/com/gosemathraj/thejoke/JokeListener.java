package com.gosemathraj.thejoke;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iamsparsh on 27/1/17.
 */

public interface JokeListener {

    void onJokeReceived(ArrayList<String> strings);
}
