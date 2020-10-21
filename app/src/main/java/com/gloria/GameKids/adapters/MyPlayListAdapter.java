package com.gloria.GameKids.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gloria.GameKids.R;
import com.gloria.GameKids.models.Item;
import com.gloria.GameKids.models.Playlistnew;
import com.google.api.services.youtube.YouTube;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyPlayListAdapter  extends RecyclerView.Adapter<MyPlayListAdapter.PlaylistViewHolder> {

    private Context mContext;
    List<Playlistnew.Item> mitemList;

    public MyPlayListAdapter(Context mcontext, List<Playlistnew.Item> mitemList) {
        this.mContext=mcontext;
        this.mitemList = mitemList;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.myImageView) ImageView mMyImageView;
        @BindView(R.id.gameNameTextView) TextView mGameNameTextView;
        @BindView(R.id.gameNameTextView2) TextView mGameNameTextView2;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public PlaylistViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindplay_list(Item items) {
            mGameNameTextView.setText(items.getSnippet().getTitle());
//            mCategoryTextView.setText(restaurant.getCategories().get(0).getTitle());
//            mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
        }
    }
}


//
//    @Override
//    public Object getItem(int position) {
//       return mitemList.get(position);
//    }
//    @Override
//    public int getCount() {
//        return mitemList.size();
//    }
//    //letterView.setText(mLetters[position]);
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//
//        return null;
//    }
//}
