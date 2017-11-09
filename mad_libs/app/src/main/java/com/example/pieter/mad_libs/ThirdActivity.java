package com.example.pieter.mad_libs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");

        EditText edittext = findViewById(R.id.edittext);
        TextView remainingtv = findViewById(R.id.displayremaining);

        edittext.setHint(story.getNextPlaceholder());
        remainingtv.setText(Integer.toString(story.getPlaceholderRemainingCount()) + " word(s) left!");
    }
//
    public void fillIn(View view) {
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");

        EditText edittext = findViewById(R.id.edittext);
        TextView remainingtv = findViewById(R.id.displayremaining);

        story.fillInPlaceholder(edittext.getText().toString());

        edittext.setHint(story.getNextPlaceholder());
        remainingtv.setText(Integer.toString(story.getPlaceholderRemainingCount()) + " word(s) left!");

        edittext.setText("");

        if (story.isFilledIn()) {
            Intent intent2 = new Intent(this, FourthActivity.class);
            intent2.putExtra("story", story);
            startActivity(intent2);
            finish();
        }
    }
}
