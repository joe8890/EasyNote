package com.joe.easynote.db.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;

import com.joe.easynote.db.DBHelper;
import com.joe.easynote.model.NoteInfo;
import com.joe.easynote.util.EasyNoteApplication;

public class NoteAction {
	private DBHelper dbhelper;
	private Context context;
	public NoteAction(Context context){
		this.context=context;
		dbhelper=((EasyNoteApplication)this.context.getApplicationContext()).getDBHelper(this.context);
	}
	public  void saveNote(String title,String content){
		NoteInfo note=new NoteInfo();
		Date date=new Date();
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String time=df.format(date);
		note.setDateTime(time);
		note.setTitle(title);
		note.setContent(content);
		dbhelper.saveNote(note);
	}
	
	public List<NoteInfo> getNoteList() {
		List<NoteInfo> notes = new ArrayList<NoteInfo>();
		notes = dbhelper.getNoteList();
		return notes;
	}
}
