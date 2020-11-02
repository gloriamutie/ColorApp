package com.gloria.GameKids.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gloria.GameKids.models.Item;
import com.gloria.GameKids.ui.DetailsFragment;

import java.util.List;

public class PlaylistPagerAdapter extends FragmentPagerAdapter {
    private List<Item> mitemlist;

    public PlaylistPagerAdapter(FragmentManager fm, int behavior,List<Item> itemlist)
    {
        super(fm,behavior);
        mitemlist=itemlist;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mitemlist.get(position).getSnippet().getChannelTitle();
    }


    @Override
    public Fragment getItem(int position) {
        return DetailsFragment.newInstance(mitemlist.get(position));
    }

    @Override
    public int getCount() {
        return mitemlist.size();
    }
}
