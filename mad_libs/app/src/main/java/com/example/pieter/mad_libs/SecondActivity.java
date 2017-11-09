package com.example.pieter.mad_libs;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goToThird(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);



        Story story;

        String storyname = "madlib0_simple.txt";
        switch (view.getId()) {
            case R.id.simplebutton:
                storyname = "madlib0_simple.txt";
                break;
            case R.id.tarzanbutton:
                storyname = "madlib1_tarzan.txt";
                break;
            case R.id.universitybutton:
                storyname = "madlib2_university.txt";
                break;
            case R.id.clothesbutton:
                storyname = "madlib3_clothes.txt";
                break;
            case R.id.dancebutton:
                storyname = "madlib4_dance.txt";
                break;
            case R.id.randombutton:
                Random rand = new Random();

                int  n = rand.nextInt(5);
                switch (n) {
                    case 0:
                        storyname = "madlib0_simple.txt";
                        break;
                    case 1:
                        storyname = "madlib1_tarzan.txt";
                        break;
                    case 2:
                        storyname = "madlib2_university.txt";
                        break;
                    case 3:
                        storyname = "madlib3_clothes.txt";
                        break;
                    case 4:
                        storyname = "madlib4_dance.txt";
                        break;
                }
        }

        InputStream is = null;

        AssetManager am = this.getAssets();
        try {
            is = am.open(storyname);
        } catch (IOException e) {
            e.printStackTrace();
        }

        story = new Story(is);

        intent.putExtra("story", story);

        startActivity(intent);
    }
}
