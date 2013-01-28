/*
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * CIS 2237 Java II
 * 
 */

package com.cis2237.chaveze2;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;


public class MainActivity extends Activity {

	private SharedPreferences prefs;
	private int closed,
				create = 0,
				start = 0,
				restart = 0,
				resume = 0,
				pause = 0, 
				stop = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		create++;
		Log.i("..⊙ ⊙..", "onCreate()");
		((TextView)findViewById(R.id.oncreateCount)
				).setText("onCreate() was called: " + create +" times");
		
		//Setting up shared pref for destroy
		prefs = getSharedPreferences("PStuff", MODE_PRIVATE);
		closed = prefs.getInt("close", 0);											//key and value for closed amount
		((TextView)findViewById(R.id.ondestroyCount)
				).setText("You've closed this program " + closed + " times.");		//show user information
		
	}
	@Override
	protected void onStart() {
		Log.i("╚═(███)═╝", "onStart()");
		start++;
		((TextView)findViewById(R.id.onstartCount)
				).setText("onStart() was called: "+start+" times");
		super.onStart();
	}
	@Override
	protected void onRestart() {
		Log.i("╚═(███)═╝", "onRestart()");
		restart++;
		((TextView)findViewById(R.id.onrestartCount)
				).setText("onRestart() was called: "+restart+" times");
		super.onRestart();
	}
	@Override
	protected void onResume() {
		Log.i("╚═(███)═╝", "onResume()");
		resume++;
		((TextView)findViewById(R.id.onresumeCount)
				).setText("onResume() was called: "+resume+" times");
		super.onResume();
	}
	@Override
	protected void onPause() {
		Log.i("╚═(███)═╝", "onPause()");
		pause++;
		((TextView)findViewById(R.id.onPauseCount)
				).setText("onPause() was called: "+pause+" times");
		super.onPause();
	}
	@Override
	protected void onStop() {
		Log.i("╚═(███)═╝", "onStop()");
		stop++;
		((TextView)findViewById(R.id.onstopCount)
				).setText("onStop() was called: "+stop+" times");
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		closed++;
		SharedPreferences.Editor ed = prefs.edit();
		ed.putInt("close", closed);
		ed.commit();
		
		Log.i("╚═(███)═╝", "onDestroy()");

		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
