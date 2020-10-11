package com.gloria.gaming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class game_list extends AppCompatActivity {
    //private ListView mListView;
    @BindView(R.id.listView) ListView mListView;

    private String[] gamelist = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ButterKnife.bind(this);
        //mListView = (ListView) findViewById(R.id.listView);
       // ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, gamelist);
        MyGamesAdapter adapter = new MyGamesAdapter(this, android.R.layout.simple_list_item_1, gamelist); // must match constructor!
        mListView.setAdapter(adapter);

    }
}