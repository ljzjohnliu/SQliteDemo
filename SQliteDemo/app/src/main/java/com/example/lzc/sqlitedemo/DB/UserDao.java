package com.example.lzc.sqlitedemo.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lzc.sqlitedemo.OpenHelper.DataOpenHelper;
import com.example.lzc.sqlitedemo.config.DBConfig;
import com.example.lzc.sqlitedemo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2016/12/16 13:49
 */


public class UserDao {
    private SQLiteDatabase db;
    private DataOpenHelper openHelper;

    public UserDao(Context context) {
     openHelper = DataOpenHelper.getInstance(context);
     db = openHelper.getReadableDatabase();
    }

    public void add(User user){
        ContentValues values = new ContentValues();
        values.put(DBConfig.FIRST_COLUMNS,user.getUserName());
        values.put(DBConfig.NEXT_COLUMNS,user.getPassWord());
        db.insert(DBConfig.TABLE_NAME,null,values);
    }

    /**
     * 删除指定姓名
     * @param name
     */
    public void delete(String name){
        db.delete(DBConfig.TABLE_NAME,DBConfig.FIRST_COLUMNS+"=?",new String[]{name});
    }

    /**
     * 更新指定名称的人
     * @param oldName
     * @param newName
     */
    public void updatae(String oldName,String newName){
        ContentValues values = new ContentValues();
        values.put(DBConfig.FIRST_COLUMNS,newName);
        db.update(DBConfig.TABLE_NAME,values,DBConfig.FIRST_COLUMNS+"=?",new String[]{oldName});
    }

    public List<User> select(){
        List<User> users = new ArrayList<>();
        String sql = "select * from "+DBConfig.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
              User user = new User();
              user.setId(cursor.getInt(0)+"");
              user.setUserName(cursor.getString(1));
              user.setPassWord(cursor.getString(2));
              users.add(user);
            }while (cursor.moveToNext());
        }
        return users;
    }
}
