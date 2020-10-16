package com.gloria.GameKids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login_details extends AppCompatActivity {
    private Button mGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);
        mGames = (Button) findViewById(R.id.Games);

        mGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_details.this, game_list.class);
                startActivity(intent);
                Toast.makeText(login_details.this, "Yaaaaay game time!!! ", Toast.LENGTH_LONG).show();

            }
        });

    }

}