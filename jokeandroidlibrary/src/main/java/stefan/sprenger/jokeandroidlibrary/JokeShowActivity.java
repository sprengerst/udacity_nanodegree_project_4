/*
 * Copyright (c) 2016. by Stefan Sprenger
 */

package stefan.sprenger.jokeandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class JokeShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_show);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(getString(R.string.joke_id_key), getIntent().getStringExtra(getString(R.string.joke_id_key)));

            JokeShowFragment fragment = new JokeShowFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.joke_detail_container, fragment)
                    .commit();
        }
    }
}
