package com.gloria.GameKids;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.gloria.GameKids.models.Playlistnew;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class play_list extends AppCompatActivity {
    //private ListView mListView;
    @BindView(R.id.listView) ListView mListView;


//    private String[] gamelist = new String[] {
//            "Shapes and colors",
//            "colors for kids,toddlers,babies",
//            "baby puzzles & toddlers games ",
//            "Monster truck games for kids2",
//            "Baby Games",
//            "Animal Farm for kids",
//            "Fun Kids Cars",
//            "Barnyard games for kids",
//            "Fishing for kids",
//            "123 numbers"
//
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ButterKnife.bind(this);
//     mListView = (ListView) findViewById(R.id.listView);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, gamelist);
//        MyPlayListAdapter adapter = new MyPlayListAdapter(this, android.R.layout.simple_list_item_1, ); // must match constructor!
//        mListView.setAdapter(adapter);
        Intent intent = getIntent();
        String playlists = intent.getStringExtra("");

        YoutubeApi client = YoutubeClient.getClient();
        Call<Playlistnew.YoutubeGameSearchResponse> call = client.getPlaylists("snippet","PLsp5EQ9nGkPnHLgg804LVAh8sSFAI9pM7","AIzaSyBAKsoD-SGXJI3xjs4G7EUFNcPc3gdsdVo");
        call.enqueue(new Callback<Playlistnew.YoutubeGameSearchResponse>(){

            @Override
            public void onResponse(Call<Playlistnew.YoutubeGameSearchResponse> call, Response<Playlistnew.YoutubeGameSearchResponse> response) {
                if (response.isSuccessful()) {
                    Playlistnew.YoutubeGameSearchResponse testresponse= response.body();
                    Log.i("Response Body",response.message());
//
                    List<Playlistnew.Item> itemList = response.body().getItems();
                    String[] items = new String[itemList.size()];


                    for (int i = 0; i < items.length; i++){
                        items[i] = itemList.get(i).getSnippet().getTitle();
                    }

                    MyPlayListAdapter adapter = new MyPlayListAdapter(play_list.this.getApplicationContext(), itemList);
                    mListView.setAdapter(adapter);

                }

            }
            @Override
            public void onFailure(Call<Playlistnew.YoutubeGameSearchResponse> call, Throwable t) {
                Toast.makeText(play_list.this,t.getMessage(),Toast.LENGTH_LONG).show();
//                Log.e(TAG.concat("API REQUEST FAILED"),t.getMessage());
            }


});

}

}
