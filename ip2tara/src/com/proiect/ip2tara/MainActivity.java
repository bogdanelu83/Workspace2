package com.proiect.ip2tara;

import com.proiect.db.GeoIPDataSource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.buton_tara);
		btn.setEnabled(false);
		InitializeDBAsync asyncTask = new InitializeDBAsync(this) {
			@Override
			protected void onPostExecute(String result) {
				btn.setEnabled(true);
				//MainActivity.this.txtIP.setText(result);
				super.onPostExecute(result);
			}
		};
		asyncTask.execute("test");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// aici adaugam activitatea Despre in meniu
		if (id == R.id.action_despre) {
			Intent intent = new Intent(this, DespreActivity.class);
			startActivity(intent);
		}

		// aici adaugam activitatea Setari in meniu
		if (id == R.id.action_setari) {
			Intent intent = new Intent(this, SetariActivity.class);
			startActivity(intent);
		}

		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// trecerea de la o activitate la alta
	public void sendMessage(View view) {
		Intent intent = new Intent(MainActivity.this, CautaActivity.class);
		startActivity(intent);
	}
}
