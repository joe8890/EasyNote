package com.joe.easynote.util;

import com.joe.easynote.db.DBHelper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.util.Log;

public class EasyNoteApplication extends Application implements
		OnSharedPreferenceChangeListener {

	private final String TAG = EasyNoteApplication.class.getSimpleName();
	private SharedPreferences prefs;
	private DBHelper dbhelper;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
		this.prefs.registerOnSharedPreferenceChangeListener(this);
		super.onCreate();
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

	/**
	 * ��ȡdbhelper����
	 * @return
	 */
	public synchronized DBHelper getDBHelper(Context context) {
		if (this.dbhelper == null) {                                                                                       
			this.dbhelper = new DBHelper(context);
		}
		return this.dbhelper;
	}
	
	/**
	 * �����˳�
	 */
	public void exit(){
		dbhelper.Close();
		System.exit(0);
	}
}
