package com.codegama.todolistapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codegama.todolistapplication.activity.MainActivity;

public class Sign_up extends AppCompatActivity {
  Button signup;
  EditText pass1,pass2,user;
  DBsqlite db=new DBsqlite(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        signup=(Button)findViewById(R.id.sign_up);
        user=(EditText)findViewById(R.id.usern);
        pass1=(EditText)findViewById(R.id.passw);
        pass2=(EditText)findViewById(R.id.pass2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String t1=pass1.getText().toString(),t2=pass2.getText().toString(),username=user.getText().toString();

                if(t1.equals("")){
                    Toast.makeText(getApplicationContext(),"please enter a valid password",Toast.LENGTH_LONG).show();

                }else{
                    if(t1.equals(t2)==false){
                        Toast.makeText(getApplicationContext(),"please confirm your password",Toast.LENGTH_LONG).show();

                    }else{
                        Boolean result=db.insertData(username,t1);
                        if(result==false){
                            Toast.makeText(getApplicationContext(),"try again ",Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(getApplicationContext(),"sign up successful",Toast.LENGTH_LONG).show();
                            Intent in = new Intent(getApplicationContext(), Login.class);
                            startActivity(in);
                        }
                    }
                }

            }
        });

    }

}

