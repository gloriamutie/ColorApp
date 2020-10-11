package com.gloria.gaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class signup_details extends AppCompatActivity {
    @BindView(R.id.createaccount)
    Button mCreateaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_details);
        ButterKnife.bind(this);

        mCreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup_details.this, login_details.class);
                startActivity(intent);
                Toast.makeText(signup_details.this, "Account created please login",Toast.LENGTH_LONG).show();
            }
        });
    }


}