package com.example.android.skeletonapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuListActivity extends ListActivity {

	private final String[] menuItems = new String[] { "Add Funds",
														"Current Balance",
														"Transaction History",
														"Tag" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		setContentView(R.layout.activity_home);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_menu_list, menuItems));
		
//		ListView listView = (ListView) findViewById(R.id.listview);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, 
									int position, long id) {
				String menuItemSelected = (String) parent.getItemAtPosition(position);
				Log.d("blah", "menuItemSelected: " + menuItemSelected);
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
				
				Intent nextIntent = null;
				if (menuItemSelected.equals("Current Balance")) {
					nextIntent = new Intent(view.getContext(), CurrentBalanceActivity.class);
				} else if (menuItemSelected.equals("Add Funds")) {
					nextIntent = new Intent(view.getContext(), MainActivity.class);
				}
				
				if (nextIntent != null) {
					view.getContext().startActivity(nextIntent);
				}
			}
		});
	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.home, menu);
//		return true;
//	}

}
