package com.gloria.GameKids.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gloria.GameKids.Constants;
import com.gloria.GameKids.R;
import com.gloria.GameKids.models.Item;
import com.gloria.GameKids.ui.DetailsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.parceler.Parcels.*;

public class FirebaseVideosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseVideosViewHolder(View itemView){
        super(itemView);
        mView=itemView;
        mContext=itemView.getContext();
        itemView.setOnClickListener(this);
    }
      public void bindPlaylist(Item items) {
          ImageView MyImageView= (ImageView)mView.findViewById(R.id.myImageView);
          TextView gameNameTextView=(TextView)mView.findViewById(R.id.gameNameTextView);
          TextView gameNameTextView2 = (TextView)mView.findViewById(R.id.gameNameTextView2);

          Picasso.get().load(items.getSnippet().getThumbnails().getHigh().getUrl()).into(MyImageView);
            gameNameTextView.setText(items.getSnippet().getChannelTitle());
            gameNameTextView2.setText(items.getSnippet().getThumbnails().getDefault().getUrl());
      //    mAuthorTextView.setText(items.getSnippet().getPublishedAt());

      }

    @Override
    public void onClick(View view) {
        final ArrayList<Item> items= new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_SAVED_VIDEOS);
          ref.addListenerForSingleValueEvent(new ValueEventListener() {
              @Override
              public void onDataChange(DataSnapshot dataSnapshot) {
                  for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                      items.add(snapshot.getValue(Item.class));
                  }
                  int itemPosition = getLayoutPosition();
                  Intent intent=new Intent(mContext, DetailsActivity.class);
                  intent.putExtra("position",itemPosition+"");
                  intent.putExtra("items", Parcels.wrap(items));
                  mContext.startActivity(intent);
              }

              @Override
              public void onCancelled(@NonNull DatabaseError error) {

              }
          });
    }
}