package com.gloria.gaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button mSignup;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSignup = (Button) findViewById(R.id.Signup);
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, signup_details.class);
                startActivity(intent);
                Toast.makeText(Login.this, "please create account", Toast.LENGTH_LONG).show();
            }
        });
        mLogin = (Button) findViewById(R.id.Login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login.this, login_details.class);
                startActivity(intent2);
                Toast.makeText(Login.this, "You can now login", Toast.LENGTH_LONG).show();
            }
        });
    }
}