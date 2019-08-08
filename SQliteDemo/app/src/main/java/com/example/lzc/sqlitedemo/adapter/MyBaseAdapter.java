package com.example.lzc.sqlitedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2016/12/16 14:37
 */


public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<T> datas;
    private Context context;
    private LayoutInflater inflater;

    public LayoutInflater getInflater() {
        return inflater;
    }

    public MyBaseAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public T getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemView(i, view, viewGroup);
    }

    public abstract View getItemView(int i, View view, ViewGroup viewGroup);

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<T> dd) {
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    public void deleteOne(String name) {
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).equals(name)) {
                datas.remove(i);
                notifyDataSetChanged();
                break;
            }
        }
    }
}
