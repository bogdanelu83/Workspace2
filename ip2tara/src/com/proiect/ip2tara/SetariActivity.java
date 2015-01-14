package com.proiect.ip2tara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SetariActivity extends Activity {

	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setari);
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
}
