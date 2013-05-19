package com.joe.easynote.activitys;

import com.joe.easynote.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public class MainActivity extends Activity {

	private MenuItem menu_item_new;
	private MenuItem menu_item_discard;
	private MenuItem menu_item_search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		menu_item_new = (MenuItem) menu.findItem(R.id.menu_new);
		menu_item_new.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this, EditorActivity.class);
				MainActivity.this.startActivity(it);
				return false;
			}

		});

		menu_item_discard = (MenuItem) menu.findItem(R.id.menu_discard);
		menu_item_discard
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						return false;
					}

				});

		menu_item_search = (MenuItem) menu.findItem(R.id.menu_search);
		menu_item_search
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						return false;
					}

				});
		return true;
	}

}
