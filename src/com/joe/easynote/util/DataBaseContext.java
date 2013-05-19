package com.joe.easynote.util;

public class DataBaseContext {
	private static DataBaseContext database;
	private static Object INSTANCE_LOCK = new Object();

	private DataBaseContext() {

	}

	public static DataBaseContext getInstance() {
		synchronized (INSTANCE_LOCK) {
			if (database == null) {
				database = new DataBaseContext();
			}
			return database;
		}
	}
}
