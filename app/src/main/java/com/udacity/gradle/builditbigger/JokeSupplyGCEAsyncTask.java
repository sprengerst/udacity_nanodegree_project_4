/*
 * Copyright (c) 2016. by Stefan Sprenger
 */

package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import stefan.sprenger.jokeandroidlibrary.JokeShowActivity;
import stefan.sprenger.jokesupplier.myApi.MyApi;

class JokeSupplyGCEAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog pDialog ;

    public JokeSupplyGCEAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute(){
        if(context != null) {
            pDialog = new ProgressDialog(context);
            pDialog.setCancelable(false);
            pDialog.setMessage(context.getString(R.string.waiting_joke_dialog));
            pDialog.show();
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(context.getString(R.string.appspot_url));
            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if( null != pDialog)
            pDialog.dismiss();

        if(context!=null) {
            Intent jokeShowIntent = new Intent(context, JokeShowActivity.class);
            jokeShowIntent.putExtra(context.getString(R.string.joke_id_key), result);
            context.startActivity(jokeShowIntent);
        }
    }
}