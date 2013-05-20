package com.joe.easynote.db;

import java.util.ArrayList;
import java.util.List;

import com.joe.easynote.model.NoteInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBHelper {
	// 数据库名称
	public static String DB_NAME = "easynote.db";

	// 数据库版本
	public static int DB_VERSION = 1;
	public static String TB_NAME = "notes";
	//private SQLiteDatabase db;
	private final SQLiteHelper dbHelper;	//私有不可变引用，保证对象只被创建一次

	public DBHelper(Context context) {
		// 定义一个SQLite数据库
 		dbHelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
	}

	public void Close() {
		dbHelper.close();
	}

	/**
	 * 获取notes表中所有记录
	 * 
	 * @return
	 */
	public List<NoteInfo> getNoteList() {
		List<NoteInfo> notes = new ArrayList<NoteInfo>();
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		try {
			Cursor cursor = db.query(TB_NAME, null, null, null, null,
					null, NoteInfo.ID+" DESC");
			try {
				cursor.moveToFirst();
				while (!cursor.isAfterLast() && cursor.getString(2) != null) {
					NoteInfo note = new NoteInfo();
					note.setId(cursor.getString(0));
					note.setDateTime(cursor.getString(1));
					note.setTitle(cursor.getString(2));
					note.setContent(cursor.getString(3));

					notes.add(note);
					cursor.moveToNext();
				}
			} finally {
				cursor.close();
			}
		} finally {
			db.close();
		}

		return notes;
	}

	/**
	 * 插入一条notes表记录
	 * 
	 * @param note
	 * @return
	 */
	public long saveNote(NoteInfo note) {
		SQLiteDatabase db = this.dbHelper.getWritableDatabase();
		long rid;
		try {
			ContentValues values = new ContentValues();
			values.put(NoteInfo.DATETIME, note.getDateTime());
			values.put(NoteInfo.TITLE, note.getTitle());
			values.put(NoteInfo.CONTENT, note.getContent());
			rid = db.insert(TB_NAME, NoteInfo.ID, values);
			Log.e("SaveNote", rid + "");
		} finally {
			db.close();
		}
		return rid;
	}

	/**
	 * 更新一条notes记录
	 * 
	 * @param note
	 * @return
	 */
	public int updateNote(NoteInfo note) {
		SQLiteDatabase db = this.dbHelper.getWritableDatabase();
		int rows;
		try {
			ContentValues values = new ContentValues();
			values.put(NoteInfo.DATETIME, note.getDateTime());
			values.put(NoteInfo.TITLE, note.getTitle());
			values.put(NoteInfo.CONTENT, note.getContent());
			rows = db.update(TB_NAME, values, NoteInfo.ID + "=" + note.getId(),
					null);
		} finally {
			db.close();
		}
		return rows;
	}

	/**
	 * 删除一条notes记录
	 * 
	 * @param id
	 * @return
	 */
	public int deleteNote(String id) {
		SQLiteDatabase db = this.dbHelper.getWritableDatabase();
		try {
			return db.delete(DB_NAME, NoteInfo.ID + "=" + id, null);
		} finally {
			db.close();
		}

	}
}
