package com.joe.easynote.util;

public class EasyNoteContext {
	private static EasyNoteContext easynote;
	private static Object INSTANCE_LOCK = new Object();

	private EasyNoteContext() {

	}

	public static EasyNoteContext getInstance() {
		synchronized (INSTANCE_LOCK) {
			if (easynote == null)
				easynote = new EasyNoteContext();
			return easynote;
		}

	}
}
