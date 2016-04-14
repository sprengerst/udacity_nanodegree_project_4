package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.gradle.jokes.JokeSupplier;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class JokeSupplyGCEAsyncTaskAndroidTest extends AndroidTestCase {

    public void testVerifyAsyncTaskTest() throws ExecutionException, InterruptedException {
        assertFalse(new JokeSupplyGCEAsyncTask(null).execute().get().isEmpty());
    }

    public void testVerifyAsyncTaskTestContains() throws ExecutionException, InterruptedException {
        System.out.println(new JokeSupplyGCEAsyncTask(null).execute().get());
        assertTrue(Arrays.asList(new JokeSupplier().getJokeArray()).contains(new JokeSupplyGCEAsyncTask(null).execute().get()));
    }
}