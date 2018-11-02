package com.example.gmjes.flashcard_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            findViewById(R.id.answer).setVisibility(View.VISIBLE);
            findViewById(R.id.question).setVisibility(View.INVISIBLE);
        }
    });

    findViewById(R.id.answer).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            findViewById(R.id.answer).setVisibility(View.INVISIBLE);
            findViewById(R.id.question).setVisibility(View.VISIBLE);
        }
    });

    findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
            MainActivity.this.startActivityForResult(intent, 100);
        }
    });

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            TextView tv2 = findViewById(R.id.question);

            TextView tv = findViewById(R.id.answer);

            tv2.setText(data.getExtras().getString("string1"));

            tv.setText(data.getExtras().getString("string2"));

            //String string1 = data.getExtras().getString("string1"); // 'string1' needs to match the key we used when we put the string in the Intent
            //String string2 = data.getExtras().getString("string2");
        }
    }
}
