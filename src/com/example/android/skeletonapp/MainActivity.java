package com.example.android.skeletonapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Clipper Card
		ImageView clipperCardImageView = (ImageView) findViewById(R.id.clipper_card_tag_here);
		clipperCardImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("droid", "Clipper Card Image clicked.  Starting Tag-On activity...");
				startOnClickActivity(TagOnActivity.class);
			}
		});
		
		// Reload Button
		Button reloadButton = (Button) findViewById(R.id.reload_button);
		reloadButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("droid", "Reload clicked.  Starting reload activity...");
				startOnClickActivity(ReloadActivity.class);
			}

		});
		
		// Transaction History
		Button transactionHistoryButton = (Button) findViewById(R.id.transaction_history_button);
		transactionHistoryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("droid", "Transaction History clicked.  Starting Transaction History activity...");
				startOnClickActivity(TransactionHistoryActivity.class);
			}
		});
	}
	
	private void startOnClickActivity(Class<? extends Activity> nextActivityClass) {
		Intent intent = new Intent(MainActivity.this, nextActivityClass);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}