package com.gloria.GameKids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gloria.GameKids.models.Item;
import com.gloria.GameKids.models.YoutubeGameSearchResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class play_list extends AppCompatActivity {
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
        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, gamelist);
//        MyPlayListAdapter adapter = new MyPlayListAdapter(this, android.R.layout.simple_list_item_1, gamelist); // must match constructor!
        mListView.setAdapter(adapter);
        Intent intent = getIntent();
//        String part = intent.getStringExtra("part");

//        YoutubeApi client = YoutubeClient.getClient();
//
//        Call<YoutubeGameSearchResponse> call = client.getPlaylists("part","key","channelId","pageToken");
//        call.enqueue(new Callback<YoutubeGameSearchResponse>() {
//            @Override
//            public void onResponse(Call<YoutubeGameSearchResponse> call, Response<YoutubeGameSearchResponse> response) {
//                if (response.isSuccessful()) {
//                    List<Item> itemList  = response.body().getItems();
//                    String[] snippet = new String[itemList.size()];
////                    String[] categories = new String[restaurantsList.size()];
//
//                    for (int i = 0; i < snippet.length; i++){
//                        snippet[i] = itemList.get(i).getEtag();
//                    }
//
////                    for (int i = 0; i < categories.length; i++) {
////                        Category category = restaurantsList.get(i).getCategories().get(0);
////                        categories[i] = category.getTitle();
////                    }
//
////                    ArrayAdapter adapter = new MyPlayListAdapter(play_list.this, android.R.layout.simple_list_item_1, snippet);
////                    mListView.setAdapter(adapter);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<YoutubeGameSearchResponse> call, Throwable t) {
//
//            }

//       0

    }
}