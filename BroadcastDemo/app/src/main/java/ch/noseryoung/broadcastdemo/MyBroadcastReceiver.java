package ch.noseryoung.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getAction());
        if (intent.ACTION_AIRPLANE_MODE_CHANGED == intent.getAction()){
            Log.d(TAG, "Handled Airplane Mode Change ");
        }
    }
}
