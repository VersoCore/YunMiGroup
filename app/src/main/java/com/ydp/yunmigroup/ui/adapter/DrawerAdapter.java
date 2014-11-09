package com.ydp.yunmigroup.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ydp.yunmigroup.App;
import com.ydp.yunmigroup.R;

/**
 * Created by YDP on 2014/11/7.
 */
public class DrawerAdapter extends BaseAdapter {

    private ListView mListView;

    public static String[] listName = {"123", "222"};

    public DrawerAdapter(ListView listView) {
        mListView = listView;
    }

    @Override
    public int getCount() {
        return listName.length;
    }

    @Override
    public Object getItem(int position) {
        return listName[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(App.sContext).inflate(R.layout.list_drawer, null);
        }
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        tvTitle.setText(listName[position]);
        tvTitle.setSelected(mListView.isItemChecked(position));
        return convertView;
    }
}
