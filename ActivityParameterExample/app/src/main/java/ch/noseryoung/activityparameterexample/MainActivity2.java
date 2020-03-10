package ch.noseryoung.activityparameterexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textview2 = findViewById(R.id.textView2);

        Intent intent = getIntent();
        String value = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        textview2.setText(value);


    }
}
