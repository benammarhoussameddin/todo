package com.codegama.todolistapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MActivity extends AppCompatActivity {
Button signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
    signup=(Button) findViewById(R.id.signup);
    login=(Button)findViewById(R.id.loginp);
    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in=new Intent(getApplicationContext(), Sign_up.class);
            startActivity(in);
        }
    });
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in1=new Intent(getApplicationContext(), Login.class);
            startActivity(in1);
        }
    });
    }

}