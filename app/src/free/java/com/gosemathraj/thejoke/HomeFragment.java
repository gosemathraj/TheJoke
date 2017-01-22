package com.gosemathraj.thejoke;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.gosemathraj.whatajokeandroidlib.WhatAJokeActivity;

import java.util.ArrayList;

/**
 * Created by iamsparsh on 19/1/17.
 */
public class HomeFragment extends Fragment implements View.OnClickListener,GetJokeAsyncTask.OnJokesFetched{

    private View view;
    private int categoryId;
    private LinearLayout categoryOne;
    private LinearLayout categoryTwo;
    private LinearLayout categoryThree;
    private LinearLayout categoryFour;
    private LinearLayout categoryFive;
    private LinearLayout categorySix;
    private LinearLayout categorySeven;
    private ProgressDialog progressDialog;
    private InterstitialAd mInterstitialAd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,container,false);

        init();
        return view;
    }

    private void init() {

        findViewById();
        setOnclickListener();
    }

    private void initAd(final ArrayList<String> strings) {

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3764011845414430/8089995906");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                progressDialog.dismiss();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                progressDialog.dismiss();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startIntent(strings);
            }
        });
    }

    private void setOnclickListener() {
        categoryOne.setOnClickListener(this);
        categoryTwo.setOnClickListener(this);
        categoryThree.setOnClickListener(this);
        categoryFour.setOnClickListener(this);
        categoryFive.setOnClickListener(this);
        categorySix.setOnClickListener(this);
        categorySeven.setOnClickListener(this);
    }

    private void findViewById() {

        categoryOne = (LinearLayout) view.findViewById(R.id.categoryOne);
        categoryTwo = (LinearLayout) view.findViewById(R.id.categoryTwo);
        categoryThree = (LinearLayout) view.findViewById(R.id.categoryThree);
        categoryFour = (LinearLayout) view.findViewById(R.id.categoryFour);
        categoryFive = (LinearLayout) view.findViewById(R.id.categoryFive);
        categorySix = (LinearLayout) view.findViewById(R.id.categorySix);
        categorySeven = (LinearLayout) view.findViewById(R.id.categorySeven);

    }


    @Override
    public void onClick(View view) {

        showProgressDialog();
        switch (view.getId()){

            case R.id.categoryOne:
                categoryId = 0;
                break;

            case R.id.categoryTwo:
                categoryId= 1;
                break;

            case R.id.categoryThree:
                categoryId = 2;
                break;

            case R.id.categoryFour:
                categoryId = 3;
                break;

            case R.id.categoryFive:
                categoryId = 4;
                break;

            case R.id.categorySix:
                categoryId = 5;
                break;

            case R.id.categorySeven:
                categoryId = 6;
                break;

        }

        new GetJokeAsyncTask(this).execute(categoryId);
    }

    private void showProgressDialog() {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("fetching Jokes");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    public void onJokesListfetched(ArrayList<String> strings) {

        if(strings != null){
            initAd(strings);
        }else{
            progressDialog.dismiss();
            showDialog();
        }
    }

    private void showDialog() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("OOPS!!!");
        alertDialogBuilder.setMessage("Something went wrong");
        alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void startIntent(ArrayList<String> strings) {

        Intent intent = new Intent(getActivity(),WhatAJokeActivity.class);
        intent.putStringArrayListExtra("jokesList",strings);
        startActivity(intent);

    }
}
