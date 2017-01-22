package com.gosemathraj.thejoke;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import com.example.iamsparsh.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by iamsparsh on 19/1/17.
 */

public class GetJokeAsyncTask extends AsyncTask<Integer, Void, ArrayList<String>> {

    private MyApi jokeApiService = null;
    private OnJokesFetched onJokesFetched;

    public GetJokeAsyncTask(Fragment onJokesFetched) {
        this.onJokesFetched = (OnJokesFetched) onJokesFetched;
    }

    @Override
    protected ArrayList<String> doInBackground(Integer... integers) {

        if(jokeApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null)
                    .setRootUrl("http://192.168.0.107:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            jokeApiService = builder.build();
        }

        try{
            return (ArrayList<String>) jokeApiService.getJoke(integers[0]).execute().getJokesList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        super.onPostExecute(strings);

        onJokesFetched.onJokesListfetched(strings);
    }

    interface OnJokesFetched{

        void onJokesListfetched(ArrayList<String> strings);
    }
}
