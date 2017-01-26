package com.gosemathraj.thejoke;

import android.app.Application;
import android.os.AsyncTask;
import android.os.ConditionVariable;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.gosemathraj.JokesCategories;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by iamsparsh on 23/1/17.
 */

public class TheJokeTest extends AndroidTestCase implements JokeListener{

    private GetJokeAsyncTask getJokeAsyncTask;
    private ConditionVariable waiter;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getJokeAsyncTask = new GetJokeAsyncTask(this);
        waiter = new ConditionVariable();
    }

    public void testJokeIsNotEmpty() {
        getJokeAsyncTask.execute(0);
        waiter.block();
    }

    @Override
    public void onJokeReceived(ArrayList<String> strings) {
        assertNotNull(strings);
        assertEquals(strings.get(0),"The four most beautiful words in our common language :A: I told you so.");
        waiter.open();
    }
}
