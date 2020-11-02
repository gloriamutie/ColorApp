package com.gloria.GameKids.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.gloria.GameKids.R;
import com.gloria.GameKids.adapters.PlaylistPagerAdapter;
import com.gloria.GameKids.models.Item;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private PlaylistPagerAdapter adapterViewPager;
    private List<Item> mitemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        mitemlist= Parcels.unwrap(getIntent().getParcelableExtra("itemlist"));

        int startingPosition = getIntent().getIntExtra("position",0);
        adapterViewPager = new PlaylistPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mitemlist);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}