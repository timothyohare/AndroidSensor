package au.id.timohare.myfirstapp;

import java.util.Iterator;
import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		//setupActionBar();
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		// Create the text view
		TextView textView = new TextView(this);
		
		SensorManager mSensorManager;
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
		textView.setTextSize(40);
		String sensorCnt = Integer.toString(deviceSensors.size());
		Iterator<Sensor> iterator = deviceSensors.iterator();
		String sensors = "";
		while (iterator.hasNext()) {
			sensors = sensors + ", " + iterator.toString();
			iterator.next();
		}
		textView.setText(sensors);
		
		// Set the text view as the activity layout
		setContentView(textView);
		
		/*View senTextView =  findViewById(R.id.sensor_text_view);
		SensorManager mSensorManager;
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
		Iterator<Sensor> iterator = deviceSensors.iterator();
		TextView sensorTextView = new TextView(this);
		sensorTextView.setTextSize(40);*/
		//String sensorCnt = Integer.toString(deviceSensors.size());
		System.out.println(deviceSensors.size());
		
		//sensorTextView.setText(deviceSensors.size());
		/*while (iterator.hasNext()) {
			TextView sensorTextView = new TextView(this);
			sensorTextView.setTextSize(40);
			sensorTextView.setText(iterator.toString());
		}*/

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
