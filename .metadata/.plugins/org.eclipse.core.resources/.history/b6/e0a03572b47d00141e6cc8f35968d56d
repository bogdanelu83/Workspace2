package com.proiect.ip2tara;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        
        
        
        
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
