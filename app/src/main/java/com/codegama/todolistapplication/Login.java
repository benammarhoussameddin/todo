package com.codegama.todolistapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codegama.todolistapplication.activity.MainActivity;

public class Login extends AppCompatActivity {
    EditText user,pass;
    Button login;
   DBsqlite db=new DBsqlite(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user=(EditText)findViewById(R.id.usern);
        pass=(EditText)findViewById(R.id.passw);
        login=(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString(),password=pass.getText().toString();
                if(username.equals("")||password.equals("")){

                    Toast.makeText(getApplicationContext(),"please enter a valid username or password",Toast.LENGTH_LONG).show();


                }else{

                    if(db.checkusers(username,password,getApplicationContext())==true){

                        Toast.makeText(getApplicationContext(),"welcom",Toast.LENGTH_LONG).show();
                        loading_bar();

                    }else{
                        Toast.makeText(getApplicationContext(),"not exist",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
    public void loading_bar(){
        final loadingbar load=new loadingbar(Login.this);
        load.showdialog();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                load.dism();

                //start find_speed_car activity
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
                finish();
            }
        },5000);
    }
}
