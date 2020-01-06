package ch.noseryoung.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText sharedPrefView1;
    EditText sharedPrefView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefView1 = findViewById(R.id.sharedPref1);
        sharedPrefView2 = findViewById(R.id.sharedPref2);

        SharedPreferences myAppPrefs = getSharedPreferences("myAppPrefs", MODE_PRIVATE);
        sharedPrefView1.setText(myAppPrefs.getString("pref1", "no default"));
        sharedPrefView2.setText(myAppPrefs.getString("pref2", "no default"));

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences myAppPrefs = getSharedPreferences("myAppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = myAppPrefs.edit();
        editor.putString("pref1", sharedPrefView1.getText().toString());
        editor.putString("pref2", sharedPrefView2.getText().toString());
        editor.commit();
    }
}
