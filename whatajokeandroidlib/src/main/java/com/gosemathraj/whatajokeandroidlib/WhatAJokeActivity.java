package com.gosemathraj.whatajokeandroidlib;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by iamsparsh on 18/1/17.
 */

public class WhatAJokeActivity extends AppCompatActivity {

    private TextView jokeText;
    private TextView nextText;
    private TextView previousText;
    private ArrayList<String> jokesList;
    private CircleImageView imageView;
    private int count = 0;

    private int[] images = {R.drawable.bunny,R.drawable.doctors,R.drawable.dogy,
            R.drawable.duck,R.drawable.face,R.drawable.girl,R.drawable.goofy,R.drawable.husbandwife,
            R.drawable.lol,R.drawable.mask,R.drawable.scooby,R.drawable.simpson};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatajoke_activity);

        init();
    }

    private void init() {

        getJokeList();
        findViewsById();
        setCustomFont();
        initialize();
        setOnClickListener();
    }

    private void setCustomFont() {

        jokeText.setTypeface(Typeface.createFromAsset(getApplicationContext().getAssets(),"quicksand.otf"));
        nextText.setTypeface(Typeface.createFromAsset(getApplicationContext().getAssets(),"quicksand.otf"));
        previousText.setTypeface(Typeface.createFromAsset(getApplicationContext().getAssets(),"quicksand.otf"));

    }

    private void initialize() {

        setImageResource();
        if(jokesList != null){

            jokeText.setText(jokesList.get(0));
            previousText.setEnabled(false);

        }
    }

    private void setImageResource() {
        imageView.setImageDrawable(getResources().getDrawable(images[new Random().nextInt(images.length)]));
    }

    private void setOnClickListener() {nextText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(!previousText.isEnabled()){
                previousText.setEnabled(true);
            }
            if(count + 1 == jokesList.size()){
                nextText.setEnabled(false);
            }else{
                setImageResource();
                count = count + 1;
            }
            jokeText.setText(jokesList.get(count));
        }
    });

        previousText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!nextText.isEnabled()){
                    nextText.setEnabled(true);
                }
                if(count  == 0){
                    previousText.setEnabled(false);
                }else{
                    setImageResource();
                    count = count - 1;
                }
                jokeText.setText(jokesList.get(count));
            }
        });


    }

    private void findViewsById() {

        jokeText = (TextView) findViewById(R.id.jokeText);
        nextText = (TextView) findViewById(R.id.nextJokeText);
        previousText = (TextView) findViewById(R.id.previousJokeText);
        imageView = (CircleImageView) findViewById(R.id.profile_image);
    }

    private void getJokeList() {

        if(getIntent() != null){

            jokesList = getIntent().getStringArrayListExtra("jokesList");
        }
    }
}
