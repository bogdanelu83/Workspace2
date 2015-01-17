package com.proiect.ip2tara;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.proiect.db.GeoIPDataSource;
import com.proiect.ip2tara.R.string;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Message;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class CautaActivity extends Activity {
	EditText txtIP;
	String country;
	private GeoIPDataSource datasource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cauta);
		txtIP = (EditText) findViewById(R.id.ip_address);
		txtIP.setRawInputType(Configuration.KEYBOARD_12KEY);
        getCurrentIP();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		datasource = new GeoIPDataSource(this);
		getMenuInflater().inflate(R.menu.cauta, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void getCountry(View view) throws IOException{
		long ipToLookup = ip2Long();
    	datasource.open();
    	country = datasource.getCountryByIP(Integer.valueOf(String.valueOf(ipToLookup)));
    	datasource.close();
		Toast.makeText(this, country, Toast.LENGTH_LONG).show();
	}
	public long ip2Long() {
		String str = txtIP.getText().toString();
		if (str.isEmpty())
			Toast.makeText(this, R.string.ip_gresit_txt, Toast.LENGTH_LONG)
					.show();
		if (!str.isEmpty()) {
			String[] ip_vector = str.split("\\.");
			long ip_long = 0;

			int ip_nr_1 = 0;
			int ip_nr_2 = 0;
			int ip_nr_3 = 0;
			int ip_nr_4 = 0;

			ip_nr_1 = Integer.parseInt(ip_vector[0]);
			ip_nr_2 = Integer.parseInt(ip_vector[1]);
			ip_nr_3 = Integer.parseInt(ip_vector[2]);
			ip_nr_4 = Integer.parseInt(ip_vector[3]);

			ip_long = (long) (ip_nr_1 * 16777216 + ip_nr_2 * 65536 + ip_nr_3
					* 256 + ip_nr_4);

			// Toast.makeText(this,Long.toString(ip_long),Toast.LENGTH_LONG).show();

			String ip_low;
			String ip_high;
			String ip_long_low;
			String ip_long_high;
			String ip_iso;
			String ip_name;
			long lng_ip_low;
			long lng_ip_high;

			return ip_long;
		}
		return 0;
	}
	
	public void getCurrentIP() {
        GetExternalIPAsync asyncTask =  new GetExternalIPAsync(){
       	@Override
       	protected void onPostExecute(String result) {
       		CautaActivity.this.txtIP.setText(result);
       		super.onPostExecute(result);
       	}
       };
       asyncTask.execute("test");
   }

	public void getCountryDetails(View view){
		Intent intent = new Intent(CautaActivity.this, TaraActivity.class);
		intent.putExtra("COUNTRY", country);
		startActivity(intent);
	}
}
