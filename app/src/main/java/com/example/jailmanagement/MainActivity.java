package com.example.jailmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button logInBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        logInBtn = (Button) findViewById(R.id.loginButton);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user") && password.getText().toString().equals("admin"))
                {
                    Toast.makeText(MainActivity.this,"Log In successfully!", Toast.LENGTH_SHORT).show();
                    openMyAppActivity();
                    username.setText("");
                    password.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this,"Log In Failed! ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void openMyAppActivity(){
        Intent intent = new Intent(MainActivity.this,MyApp.class);
        startActivity(intent);
    }
}