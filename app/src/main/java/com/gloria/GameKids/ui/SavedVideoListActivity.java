package com.gloria.GameKids.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedVideoListActivity extends AppCompatActivity {
    private DatabaseReference mVediosReference;
    private FirebaseRecyclerAdapter<Item, FirebaseVideosViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ButterKnife.bind(this);

        mVediosReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_SAVED_VIDEOS);
        setUpFirebaseAdapter();

    }

    private void setUpFirebaseAdapter() {

        FirebaseRecyclerOptions<Item> options = new FirebaseRecyclerOptions.Builder<Item>()
                .setQuery(mVediosReference, Item.class)
                .build();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Item, FirebaseVideosViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseVideosViewHolder firebaseVideosViewHolder, int i, @NonNull Item item) {
        progressBar.setVisibility(View.INVISIBLE);
                mRecyclerView.setVisibility(View.VISIBLE);

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