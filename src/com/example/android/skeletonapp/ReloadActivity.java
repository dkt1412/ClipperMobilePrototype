package com.example.android.skeletonapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;

public class ReloadActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reload);

		final Spinner paymentOptionSpinner = (Spinner) findViewById(R.id.payment_options_spinner);
		paymentOptionSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			boolean showEditText = false;

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Log.d("droid", "Show edit text? " + showEditText);
				if (showEditText) {
					EditText accountInfoEditText = (EditText) findViewById(R.id.account_info_edit_box);
					accountInfoEditText.setVisibility(View.VISIBLE);
					accountInfoEditText.setFocusable(true);
				} else {
					showEditText = true;
					paymentOptionSpinner.setSelection(-1);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Log.d("droid", "Show edit text on nothing selected? " + showEditText);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reload, menu);
		return true;
	}
}
