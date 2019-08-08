package com.example.lzc.sqlitedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lzc.sqlitedemo.R;
import com.example.lzc.sqlitedemo.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2016/12/16 14:39
 */


public class ListViewAdapter extends MyBaseAdapter<User> {
    public ListViewAdapter(List<User> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getItemView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = getInflater().inflate(R.layout.listview_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textId.setText(getItem(i).getId());
        viewHolder.textUserName.setText(getItem(i).getUserName());
        viewHolder.textPassword.setText(getItem(i).getPassWord());
        return view;
    }


    class ViewHolder {
        @BindView(R.id.textview_id)
        TextView textId;
        @BindView(R.id.textview_username)
        TextView textUserName;
        @BindView(R.id.textview_password)
        TextView textPassword;

        public ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }
}
