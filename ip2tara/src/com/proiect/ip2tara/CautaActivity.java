package com.proiect.ip2tara;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class CautaActivity extends Activity {
	


	   
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cauta);
	  
	   
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
	        
	      //aici adaugam activitatea Despre in meniu   
	        if(id==R.id.action_despre) {
	    		Intent intent = new Intent (this, DespreActivity.class);
	    		startActivity (intent);
	    	}
	        
	        //aici adaugam activitatea Setari in meniu 
	        if(id==R.id.action_setari) {
	    		Intent intent = new Intent (this, SetariActivity.class);
	    		startActivity (intent);
	    	}
	      //aici adaugam activitatea Istoric in meniu 
	        if(id==R.id.action_istoric) {
	    		Intent intent = new Intent (this, IstoricActivity.class);
	    		startActivity (intent);
	    	}
	      //aici adaugam activitatea Tari in meniu 
	        if(id==R.id.action_tari) {
	    		Intent intent = new Intent (this, TaraActivity.class);
	    		startActivity (intent);
	    	}
	                      
	     
	        return super.onOptionsItemSelected(item);
	    }


	public void ip2Long(View view){

		EditText txt = (EditText)findViewById(R.id.ip_address);
		String str = txt.getText().toString();
		if(str.isEmpty())
			Toast.makeText(this,R.string.ip_gresit_txt,Toast.LENGTH_LONG).show();
	
		if(!str.isEmpty()){
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
					
	ip_long = (long) (  ip_nr_1 * 16777216 +
						ip_nr_2 * 65536+
						ip_nr_3 * 256+
						ip_nr_4 );

		Toast.makeText(this,Long.toString(ip_long),Toast.LENGTH_LONG).show();

		
		String ip_low;
		String ip_high;
		String ip_long_low;
		String ip_long_high;
		String ip_iso;
		String ip_name;
		long lng_ip_low;
		long lng_ip_high;
		
	    try {
	    	 File file = new File("./bin/GeoIP.csv");
	         BufferedReader reader = new BufferedReader(new FileReader(file));
	         reader.readLine();
	         String line = null;
	        while ((line = reader.readLine()) != null) {
	             String[] RowData = line.split(",");
	             ip_low = RowData[0];
	             ip_high = RowData[1];
	             ip_long_low = RowData[2];
	             ip_long_high = RowData[3];
	             ip_iso = RowData[4];
	             ip_name = RowData[5];
	            
	             lng_ip_low = Long.parseLong(ip_long_low);
	             lng_ip_high = Long.parseLong(ip_long_high);
	             if(lng_ip_low < ip_long && ip_long > lng_ip_high)
	            		Toast.makeText(this,ip_name,Toast.LENGTH_LONG).show();	            	 
	        }
	        reader.close();
	        
	        }
	    catch (IOException ex) {
	    }
	    }
			 		
	}

}
