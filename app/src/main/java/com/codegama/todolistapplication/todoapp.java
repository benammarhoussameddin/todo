package com.codegama.todolistapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class todoapp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_app);

        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    Intent in = new Intent(getApplicationContext(),MActivity.class);
                    sleep(3000);
                    startActivity(in);
                    finish();

                } catch (Exception e) {

                }
            }
        };
        th.start();

        }
}
