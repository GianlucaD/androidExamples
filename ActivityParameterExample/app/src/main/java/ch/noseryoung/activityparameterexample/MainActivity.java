package ch.noseryoung.activityparameterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "ch.noseryoung.activityparameterexample.EXTRA_TEXT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button openButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openButton = findViewById(R.id.button);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    private void openActivity2() {
        EditText text = findViewById(R.id.editText);
        String value = text.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_TEXT, value);
        startActivity(intent);
    }
}