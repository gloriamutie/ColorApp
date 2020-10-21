//package com.gloria.GameKids.adapters;
//
//        import android.support.v4.app.Fragment;
//        import android.support.v4.app.FragmentManager;
//        import android.support.v4.app.FragmentPagerAdapter;
//
//
//        import com.gloria.GameKids.models.Item;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class PlaylistPagerAdapter extends FragmentPagerAdapter {
//    private List<Item> mitemList;
//
//    public PlaylistPagerAdapter(FragmentManager fm, int behavior, List<Item> restaurants) {
//        super(fm, behavior);
//        mitemList = restaurants;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        return PlaylistPagerAdapter.newInstance(mitemList.get(position));
//    }
//
//    @Override
//    public int getCount() {
//        return mitemList.size();
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mitemList.get(position).getName();
//    }
//}
