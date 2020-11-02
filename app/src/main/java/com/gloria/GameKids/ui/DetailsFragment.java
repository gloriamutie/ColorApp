package com.gloria.GameKids.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gloria.GameKids.R;
import com.gloria.GameKids.Saved;
import com.gloria.GameKids.models.Item;
import com.gloria.GameKids.models.SavedVideos;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailsFragment extends Fragment  {
    @BindView(R.id.youtube_player_view) YouTubePlayerView youTubePlayerView;
    @BindView(R.id.gameNameTextView) TextView mGameNameTextView;
    @BindView(R.id.vediodescription) TextView mGameNameTextView2;
    @BindView(R.id.saveVediosButton) Button mSavedVideos;
    @BindView(R.id.firebaseVideos) Button mFirebaseVideos;





    private Item mitems;

    public DetailsFragment(){
        // Required empty public constructor

    }

    public static DetailsFragment newInstance(Item items) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("items", Parcels.wrap(items));
        detailsFragment.setArguments(args);
        return detailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mitems= Parcels.unwrap(getArguments().getParcelable("items"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);
        ButterKnife.bind(this, view);

//       Picasso.get().load(mitems.getSnippet().getThumbnails().getDefault().getUrl()).into(mMyImageView);
        mFirebaseVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getContext(),SavedVideoListActivity.class));
                startActivity(new Intent(getContext(), Saved.class));
//                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

mSavedVideos.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      SaveVideo();
    }

});
        mGameNameTextView.setText(mitems.getSnippet().getTitle());
        mGameNameTextView2.setText(mitems.getSnippet().getPublishedAt());

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                youTubePlayer.loadVideo(mitems.getSnippet().getResourceId().getVideoId(), 0);
            }
        });
        return view;
    }

 public   void SaveVideo(){
     FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
     FirebaseFirestore fStore = FirebaseFirestore.getInstance();
     DocumentReference documentReference = fStore.collection("videos").document();
     documentReference.set(new SavedVideos(currentUser.getUid(),mitems.getSnippet().getResourceId().getVideoId())).addOnSuccessListener(new OnSuccessListener<Void>() {
         @Override
         public void onSuccess(Void aVoid) {
             Toast.makeText(getContext(),"Video was saved succeddfully",Toast.LENGTH_LONG).show();
         }
     });

    }
}