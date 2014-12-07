package com.proiect.ip2tara;



import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;


@SuppressWarnings("unused")
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
        
        
        
     
        return super.onOptionsItemSelected(item);
    }

  //trecerea de la o activitate la alta  
    public void sendMessage(View view) 
    {
        Intent intent = new Intent(MainActivity.this, CautaActivity.class);
        startActivity(intent);
    }


  
    
 
   }
 












