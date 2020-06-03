package com.noseryoung.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText phone;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(phone);
            }
        });
        phone = findViewById(R.id.phonenumber);
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    phone.setError("Eingabe obligatorisch");
                }


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                validate(phone);
            }
        });

    }

    private void validate(EditText editable) {
        if (editable == phone) {
            if (phone.getText().length() == 0) {
                phone.setError("Eingabe obligatorisch");
            }
        }
    }
}
