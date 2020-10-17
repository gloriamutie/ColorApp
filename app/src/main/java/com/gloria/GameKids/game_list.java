package com.gloria.GameKids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.gloria.GameKids.models.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class game_list extends AppCompatActivity {
    //private ListView mListView;
    @BindView(R.id.listView) ListView mListView;

    private String[] gamelist = new String[] {
            "Shapes and colors",
            "colors for kids,toddlers,babies",
            "baby puzzles & toddlers games ",
            "Monster truck games for kids2",
            "Baby Games",
            "Animal Farm for kids",
            "Fun Kids Cars",
            "Barnyard games for kids",
            "Fishing for kids",
            "123 numbers"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ButterKnife.bind(this);
        //mListView = (ListView) findViewById(R.id.listView);
       // ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, gamelist);
        MyGamesAdapter adapter = new MyGamesAdapter(this, android.R.layout.simple_list_item_1, gamelist); // must match constructor!
        mListView.setAdapter(adapter);

        YoutubeApi client = YoutubeClient.getClient();

        Call<com.gloria.GameKids.YoutubeGameSearchResponse> call = client.getPlaylists("part","key","channelId");

    }
}