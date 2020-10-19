package com.gloria.GameKids;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyPlayListAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mgamelist;

    public MyPlayListAdapter(Context mcontext, int resource, String[] mgamelist) {
        super(mcontext, resource);
        this.mContext=mcontext;
        this.mgamelist = mgamelist;

    }
    @Override
    public Object getItem(int position) {
        String allgames = mgamelist[position];
        return String.format(allgames);
    }
    @Override
    public int getCount() {
        return mgamelist.length;
    }
    //letterView.setText(mLetters[position]);
    @Override
    public long getItemId(int position) {
        return 0;
    }
}
