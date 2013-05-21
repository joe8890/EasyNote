package com.joe.easynote.activitys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.joe.easynote.R;
import com.joe.easynote.db.action.NoteAction;
import com.joe.easynote.model.NoteInfo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private MenuItem menu_item_new;
	private MenuItem menu_item_discard;
	private MenuItem menu_item_search;
	private ListView listview_note;
	private List<Map<String, Object>> notelist;
	private List<NoteInfo> notes;

	// private easyNoteAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview_note = (ListView) this
				.findViewById(R.id.listView_note);
		notelist=this.getData();
		// 暂时用一个简单的adapter，后续优化
		SimpleAdapter adapter = new SimpleAdapter(this, notelist,
				R.layout.sub_item_contents,
				new String[] { "datetime", "title" }, new int[] {
						R.id.textView_listview_datetime,
						R.id.textView_listview_title });
		listview_note.setAdapter(adapter);
		listview_note.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int index,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,EditorActivity.class);
				Bundle bundle=new Bundle();
				bundle.putSerializable("noteinfo", notes.get(index));
				intent.putExtras(bundle);
				intent.putExtra("mode", 1);
				MainActivity.this.startActivity(intent);
				//view
			}
			
		});
		// DataBaseContext.getInstance(this);
	}

	/**
	 * 先暂时取出title，未完待续
	 * 
	 * @return
	 */
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		NoteAction na = new NoteAction(this);
		notes = na.getNoteList();
		for (int i = 0; i < notes.size(); i++) {
			NoteInfo note = notes.get(i);
			map = new HashMap<String, Object>();
			map.put("datetime", note.getDateTime());
			map.put("title", note.getTitle());
			map.put("content", note.getContent());
			// map.put("content", note.getContent());
			list.add(map);
		}
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		menu_item_new = menu.findItem(R.id.menu_new);
		menu_item_new.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this, EditorActivity.class);
				MainActivity.this.startActivity(it);
				return false;
			}

		});

		menu_item_discard = menu.findItem(R.id.menu_discard);
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
