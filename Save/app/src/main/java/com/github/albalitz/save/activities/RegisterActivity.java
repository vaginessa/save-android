package com.github.albalitz.save.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.albalitz.save.R;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonRegister;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(this.toString(), "Creating RegisterActivity.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
