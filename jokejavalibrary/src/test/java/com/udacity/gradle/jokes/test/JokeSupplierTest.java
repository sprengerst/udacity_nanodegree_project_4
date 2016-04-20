/*
 * Copyright (c) 2016. by Stefan Sprenger
 */

package com.udacity.gradle.jokes.test;

import com.udacity.gradle.jokes.JokeSupplier;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class JokeSupplierTest {
    @Test
    public void test() {
        JokeSupplier jokeSupplier = new JokeSupplier();
        assertTrue(jokeSupplier.getJoke().length() != 0);
    }
}