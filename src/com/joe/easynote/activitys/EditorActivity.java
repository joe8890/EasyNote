package com.joe.easynote.activitys;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;

import com.joe.easynote.R;
import com.joe.easynote.db.action.NoteAction;

public class EditorActivity extends Activity {

	private MenuItem menu_item_save;
	private MenuItem menu_item_cancal;

	private EditText text_title;
	private EditText text_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editor);

		text_title = (EditText) this.findViewById(R.id.editText_title);
		text_content = (EditText) this.findViewById(R.id.editText_content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_editor, menu);
		menu_item_save = menu.findItem(R.id.menu_save);
		menu_item_save
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						NoteAction na = new NoteAction(EditorActivity.this);
						na.saveNote(text_title.getText().toString(),
								text_content.getText().toString());
						Intent it = new Intent(EditorActivity.this,
								MainActivity.class);
						EditorActivity.this.startActivity(it);
						return false;
					}

				});

		menu_item_cancal = menu.findItem(R.id.menu_cancel);
		menu_item_cancal
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						text_title.setText("");
						text_content.setText("");
						return false;
					}

				});
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.finish();
	}

}
