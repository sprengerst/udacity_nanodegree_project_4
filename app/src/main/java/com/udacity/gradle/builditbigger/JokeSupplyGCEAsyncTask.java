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
            pDialog.setMessage("Fetch a new joke");
            pDialog.show();
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                // options for running against local devappserver
//                // - 10.0.2.2 is localhost's IP address in Android emulator
//                // - turn off compression when running against local devappserver
//                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                    @Override
//                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                        abstractGoogleClientRequest.setDisableGZipContent(true);
//                    }
//                });
//                // end options for devappserver

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://nanodegreeproject4.appspot.com/_ah/api/");
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
            jokeShowIntent.putExtra("JOKE_ID", result);
            context.startActivity(jokeShowIntent);
        }
    }
}