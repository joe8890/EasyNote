package com.joe.easynote.activitys;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.joe.easynote.R;
public class EditorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editor);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_editor, menu);
		return true;
	}

}
