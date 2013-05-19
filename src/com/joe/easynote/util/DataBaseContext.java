package com.joe.easynote.util;

import android.content.Context;

import com.joe.easynote.db.DBHelper;

public class DataBaseContext {
	private static DBHelper database;
	private static Object INSTANCE_LOCK = new Object();

	public static DBHelper getInstance(Context context) {
		synchronized (INSTANCE_LOCK) {
			if (database == null) {
				database = new DBHelper(context);
			}
			return database;
		}
	}
}
