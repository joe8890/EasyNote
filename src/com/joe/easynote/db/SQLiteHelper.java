package com.joe.easynote.db;

import com.joe.easynote.model.NoteInfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	


	public SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS " + DBHelper.TB_NAME + "(" + 
				NoteInfo.ID+ " integer primary key," + 
				NoteInfo.DATETIME + " datetime,"+ 
				NoteInfo.TITLE + " varchar(50)," + 
				NoteInfo.CONTENT + " text"
				+ ")");
		Log.e("database", "created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
