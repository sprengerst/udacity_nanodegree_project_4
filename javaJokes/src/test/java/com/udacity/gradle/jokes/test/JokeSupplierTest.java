package com.udacity.gradle.jokes.test;

import com.udacity.gradle.jokes.JokeSupplier;

import org.junit.Test;

public class JokeSupplierTest {
    @Test
    public void test() {
        JokeSupplier jokeSupplier = new JokeSupplier();
        assert jokeSupplier.getJoke().length() != 0;
    }
}