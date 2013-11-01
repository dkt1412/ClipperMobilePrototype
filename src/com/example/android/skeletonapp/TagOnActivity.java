package com.example.android.skeletonapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TagOnActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tag_on);
		
		Button tagCompletedButton = (Button) findViewById(R.id.tag_on_completed_button);
		tagCompletedButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("droid", "Tag On Completed.  Starting Transaction History activity...");
				Intent transactionHistoryIntent = new Intent (TagOnActivity.this, TransactionHistoryActivity.class);
				startActivity(transactionHistoryIntent);
			}
		});
		
		Button tagErrorButton = (Button) findViewById(R.id.tag_on_error_button);
		tagErrorButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("droid", "Tag On ERROR.  Starting Tag On Error activity...");
				Intent transactionHistoryIntent = new Intent (TagOnActivity.this, TagOnErrorActivity.class);
				startActivity(transactionHistoryIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tag_on, menu);
		return true;
	}

}
