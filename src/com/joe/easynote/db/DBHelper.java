package com.joe.easynote.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DBHelper {
	// ���ݿ�����
	private static String DB_NAME = "easynote.db";
	
	// ���ݿ�汾
	private static int DB_VERSION = 1;
	private SQLiteDatabase db;
	private SQLiteHelper dbHelper;
	
	public DBHelper(Context context) {
		//����һ��SQLite���ݿ�
		dbHelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	public void Close() {
		db.close();
		dbHelper.close();
	}
}
