package com.joe.easynote.model;

import java.io.Serializable;

public class NoteInfo implements Serializable {
	public static final String ID = "_id";
	public static final String DATETIME = "_datetime";
	public static final String TITLE = "_title";
	public static final String CONTENT = "_content";

	private String id;
	private String datetime;
	private String title;
	private String content;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateTime() {
		return this.datetime;
	}

	public void setDateTime(String datetime) {
		this.datetime = datetime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
