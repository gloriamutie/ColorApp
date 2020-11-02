package com.gloria.GameKids;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
     Context context;
    public TextView textView,textView2;
    public ImageView imageView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        //
        context = itemView.getContext();
        textView = itemView.findViewById(R.id.gameNameTextView);
        textView2 = itemView.findViewById(R.id.gameNameTextView2);
        imageView = itemView.findViewById(R.id.myImageView);
        //

    }


}
