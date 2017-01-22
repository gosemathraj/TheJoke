package com.gosemathraj.thejoke;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.frameContainer);
        if(frag == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameContainer,new HomeFragment()).commit();
        }

    }
}
