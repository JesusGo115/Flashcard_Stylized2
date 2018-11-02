package com.example.gmjes.flashcard_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String newQuestion = ((EditText) findViewById(R.id.newQuestion)).getText().toString();

            String newAnswer = ((EditText) findViewById(R.id.newAnswer)).getText().toString();

            Intent data = new Intent();
            data.putExtra( "string1",newQuestion);
            data.putExtra( "string2", newAnswer);
            setResult(RESULT_OK, data);
            finish();
        }
    });
}}
