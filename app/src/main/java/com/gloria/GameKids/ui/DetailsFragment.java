package com.gloria.GameKids.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gloria.GameKids.R;
import com.gloria.GameKids.models.Item;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    @BindView(R.id.myImageView) ImageView mMyImageView;
    @BindView(R.id.gameNameTextView) TextView mGameNameTextView;
    @BindView(R.id.gameNameTextView2) TextView mGameNameTextView2;
    @BindView(R.id.ratingTextView) TextView mRatingTextView;

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
        View view = inflater.inflate(R.layout.activity_details,container,false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mitems.getSnippet().getThumbnails()).into(mMyImageView);

        mGameNameTextView.setText(mitems.getSnippet().getTitle());
        mGameNameTextView2.setText(mitems.getSnippet().getDescription());


        return view;
    }

}