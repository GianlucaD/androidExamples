package com.noseryoung.WriteFile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private TextView contentView;
    private OutputStreamWriter outputStreamWriter;
    private static String FILENAME = "config.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        contentView = findViewById(R.id.contentTextView);
        File f = getFile(context);
        // if file doesn't exist we create a default one
        if (!f.exists()) {
            initFile(context);
        }

        //read the file
        StringBuilder text = readFile(context);
        TextView tv = (TextView)findViewById(R.id.contentTextView);
        tv.setText(text.toString());
    }

    private File getFile(Context context) {
        return new File(context.getFilesDir(), FILENAME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getFile(getApplicationContext()).delete();

    }

    public void saveFile(View view){
        Context context = getApplicationContext();
        String data = contentView.getText().toString();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(FILENAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Toast.makeText(context, "File successfully saved", Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private StringBuilder readFile(Context context) {
        StringBuilder text = new StringBuilder();
        BufferedReader br = null;
        try {
            File file = getFile(context);
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            } }
        catch (IOException e) {
            e.printStackTrace();

        }
        finally{
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Log.e(TAG, "onCreate: ",e );
                }
            }
        }
        return text;
    }

    private void initFile(Context context) {
        try {
            outputStreamWriter = new OutputStreamWriter(context.openFileOutput(FILENAME, context.MODE_PRIVATE));
            String data = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
            outputStreamWriter.write(data);
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        } finally {
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    //nop nothing i can do.
                }
            }
        }
    }

}

