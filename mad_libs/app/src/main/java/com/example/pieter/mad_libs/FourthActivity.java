package com.example.pieter.mad_libs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");

        TextView result = findViewById(R.id.resulttext);
        result.setText(story.toString());
    }
}
