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
        if (intent.ACTION_BOOT_COMPLETED == intent.getAction()){
            Toast toast = Toast.makeText(context, "Boot did complete", Toast.LENGTH_LONG);
            toast.show();
        }
        if (intent.ACTION_AIRPLANE_MODE_CHANGED == intent.getAction()){
            Toast toast = Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
