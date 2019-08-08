package com.example.lzc.sqlitedemo.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lzc.sqlitedemo.config.DBConfig;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2016/12/16 13:17
 */

public class DataOpenHelper extends SQLiteOpenHelper {
    public static DataOpenHelper openHelper;

    public DataOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static DataOpenHelper getInstance(Context context) {
        if (openHelper == null) {
            synchronized (DataOpenHelper.class) {
                if (openHelper == null) {
                    openHelper = new DataOpenHelper(context, DBConfig.DB_NAME, null, DBConfig.DB_VERSION);
                }
            }
        }
        return openHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + DBConfig.TABLE_NAME + "(" + DBConfig.DB_ID + " integer primary key UNIQUE,"
                + DBConfig.FIRST_COLUMNS + " text UNIQUE," + DBConfig.NEXT_COLUMNS + " text);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //只有更新数据库才执行该方法，
        sqLiteDatabase.execSQL("drop table " + DBConfig.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
