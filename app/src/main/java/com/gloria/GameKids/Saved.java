package com.gloria.GameKids;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.gloria.GameKids.models.SavedVideos;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Saved extends AppCompatActivity {
    private static final String TAG = "saved videos";
    //
    private CollectionReference mVidRef;
//    private RecyclerView mFirestrecyc;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerOptions options;
    private FirestoreRecyclerAdapter adapter;
    //
    @BindView(R.id.Firestrecyc) RecyclerView mNewRec;

    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        ButterKnife.bind(this);

        firebaseFirestore = FirebaseFirestore.getInstance();
//        mFirestrecyc = findViewById(R.id.Firestrecyc);

// query from from firestore using recycler options and viewholder class
//
        Query query = firebaseFirestore.collection("videos");

//Recycleroptions
        options = new FirestoreRecyclerOptions.Builder<SavedVideos>().setQuery(query, SavedVideos.class)
                .build();
//        create recycleradpter
        adapter = new FirestoreRecyclerAdapter<SavedVideos,
                MyViewHolder>(options) {
            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_baby_videos,parent,false);
                return new MyViewHolder(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int i, @NonNull SavedVideos savedVideos) {
                holder.imageView.setImageResource(R.drawable.gamelist);
                holder.textView.setText(savedVideos.getUserId());
                holder.textView2.setText(savedVideos.getVideoId());
            }
        };

        mNewRec.setLayoutManager(new LinearLayoutManager(this));
        mNewRec.setHasFixedSize(true);
        mNewRec.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
