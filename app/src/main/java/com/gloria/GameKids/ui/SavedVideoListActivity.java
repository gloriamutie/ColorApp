package com.gloria.GameKids.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.gloria.GameKids.Constants;
import com.gloria.GameKids.R;
import com.gloria.GameKids.adapters.FirebaseVideosViewHolder;
import com.gloria.GameKids.models.Item;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedVideoListActivity extends AppCompatActivity {
    private static final String TAG = "saved videos";
    private DatabaseReference mVideosReference;
    private FirebaseRecyclerAdapter<Item, FirebaseVideosViewHolder> mFirebaseAdapter;
    private String userId;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ButterKnife.bind(this);

        mVideosReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_SAVED_VIDEOS);
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        setUpFirebaseAdapter();
        fetch();


    }

    private void fetch() {
        DatabaseReference videos = mVideosReference.child(userId);
        videos.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot each: snapshot.getChildren()){
                        each.getKey();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setUpFirebaseAdapter() {

        FirebaseRecyclerOptions<Item> options = new FirebaseRecyclerOptions.Builder<Item>()
                .setQuery(mVideosReference, Item.class)
                .build();
        Log.i(TAG, options.toString());
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Item, FirebaseVideosViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseVideosViewHolder firebaseVideosViewHolder, int i, @NonNull Item item) {
//                progressBar.setVisibility(View.INVISIBLE);
//                mRecyclerView.setVisibility(View.VISIBLE);

            }

            @NonNull
            @Override
            public FirebaseVideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_baby_videos, parent, false);
                return new FirebaseVideosViewHolder(view);
            }

        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
        progressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFirebaseAdapter.stopListening();
    }
}