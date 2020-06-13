package ch.noseryoung.broadcastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyBroadcast";

    // Person
    TextView textview1;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;
    TextView textview7;

    // Adresse
    TextView text2

// Methoden für Ablauf

    MyBroadcastReceiver broadcastReceiver = new MyBroadcastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        getApplication().getApplicationContext().registerReceiver(broadcastReceiver, filter);
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        this.unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
}
