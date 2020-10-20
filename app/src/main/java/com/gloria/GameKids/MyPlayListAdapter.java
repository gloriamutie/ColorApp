package com.gloria.GameKids;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.gloria.GameKids.models.Playlistnew;

import java.util.List;

public class MyPlayListAdapter extends BaseAdapter {
    private Context mContext;
    List<Playlistnew.Item> mitemList;

    public MyPlayListAdapter(Context mcontext, List<Playlistnew.Item> mitemList) {
        this.mContext=mcontext;
        this.mitemList = mitemList;
    }

    @Override
    public Object getItem(int position) {
       return mitemList.get(position);
    }
    @Override
    public int getCount() {
        return mitemList.size();
    }
    //letterView.setText(mLetters[position]);
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        return null;
    }
}
