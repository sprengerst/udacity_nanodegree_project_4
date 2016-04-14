package com.udacity.gradle.jokes;

import java.util.Random;

public class JokeSupplier {


    public String[] getJokeArray() {
        return jokeArray;
    }

    private String[] jokeArray = new String[]{
            "A woman noticed her husband standing on the bathroom scale, sucking in his stomach. \"Ha! That’s not going to help,\" she said.\n" +
                    "\n" +

                    "\"Sure, it does,\" he said. \"It's the only way I can see the numbers.\"",
            "Please stop calling us your \"squad,\" Linda; this is book club.",
            "We were inspecting several lots of grenades. While everyone was concentrating on the task at hand, I held up a spare pin and asked, \"Has anyone seen my grenade?\""
    };

    Random randomInt = new Random();

    public String getJoke(){
        int idx = randomInt.nextInt(jokeArray.length);
        return (jokeArray[idx]);
    }
}