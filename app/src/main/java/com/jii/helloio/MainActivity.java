package com.jii.helloio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView name;
    EditText textBox;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO your main logic  here:

        name = findViewById(R.id.user_name);
        textBox = findViewById(R.id.textBox);
        next = findViewById(R.id.nextBtn);

        textBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                nameChanged(textBox.getText().toString());
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textBox.length() != 0) {
                    textBox.clearFocus();
                    Toast.makeText(MainActivity.this, "name has been set successfully".toString(), Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this,"Please Enter you name".toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void nameChanged(String new_name) {
        name.setText(new_name);
    }
}