package com.gzeinnumer.checkbeforeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gzeinnumer.cbi.CheckBeforeIntent;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.ed);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            check();
        });

    }

    private void check() {
        CheckBeforeIntent.with(getApplicationContext()).addView(editText).isSaveToLeave(new CheckBeforeIntent.CheckBeforeIntentCallBack() {
            @Override
            public void isSaveToLeave(boolean isSave) {
                //if
                // isSave = true -> free to lease
                //else
                // isSave = false -> not free to leave

                if (isSave)
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                else
                    Toast.makeText(MainActivity.this, "gak aman", Toast.LENGTH_SHORT).show();
            }
        }).build();
    }
}