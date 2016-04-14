package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button loadJokeBtn = (Button) root.findViewById(R.id.tell_joke_btn);
        loadJokeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new JokeSupplyGCEAsyncTask(getContext()).execute();
            }
        });

        return root;
    }
}
