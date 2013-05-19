package com.joe.easynote.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DBHelper {
	// 数据库名称
	private static String DB_NAME = "easynote.db";
	
	// 数据库版本
	private static int DB_VERSION = 1;
	private SQLiteDatabase db;
	private SQLiteHelper dbHelper;
	
	public DBHelper(Context context) {
		//定义一个SQLite数据库
		dbHelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	public void Close() {
		db.close();
		dbHelper.close();
	}
}
