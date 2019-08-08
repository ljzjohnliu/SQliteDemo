package com.example.lzc.sqlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lzc.sqlitedemo.db.UserDao;
import com.example.lzc.sqlitedemo.adapter.ListViewAdapter;
import com.example.lzc.sqlitedemo.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 类描述：SQlite测试
 * 创建人：zz
 * 创建时间：2016/12/16 13:10
 */
public class MainActivity extends Activity {

    private Unbinder unbinder;

    @BindView(R.id.listview_id)
    ListView listView;
    @BindView(R.id.button_add)
    Button buttonAdd;
    @BindView(R.id.button_delete)
    Button buttonDelete;
    @BindView(R.id.button_update)
    Button buttonUpdate;
    @BindView(R.id.button_select)
    Button buttonSelect;
    private UserDao dao;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        dao = new UserDao(MainActivity.this);
        setData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.button_add, R.id.button_delete, R.id.button_update, R.id.button_select})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                add();
                break;
            case R.id.button_delete:
                delete();
                break;
            case R.id.button_update:
                update();
                break;
            case R.id.button_select:
                select();
                break;
        }
    }

    /**
     * 查询数据
     */
    private void select() {
        adapter.clear();
        adapter.addAll(dao.select());
    }

    /**
     * 删除数据
     */
    private void delete() {
        dao.delete("测试测试1");
    }

    /**
     * 添加数据
     */
    private void add() {
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUserName("测试测试" + i);
            user.setPassWord(i + "" + i + "" + i + "");
            dao.add(user);
        }
    }

    /**
     * 更新操作
     */
    private void update() {
        dao.updatae("测试测试3", "XXX");
    }

    private void setData() {
        adapter = new ListViewAdapter(new ArrayList<User>(), getApplicationContext());
        listView.setAdapter(adapter);
    }
}
