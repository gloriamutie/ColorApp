package com.gloria.GameKids.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
//keep track number of tabs
    private int numberOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm,int behaviour,int numberOfTabs) {
        super(fm, behaviour);
        this.numberOfTabs=numberOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
               return new Login();
           case 1:
               return new Register();
           default:
               return null;
       }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
