package com.proiect.ip2tara;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.net.Uri;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class DespreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_despre);
	
	
		   Button startBtn = (Button) findViewById(R.id.sendEmail);
		      startBtn.setOnClickListener(new View.OnClickListener() {
		         public void onClick(View view) {
		         sendEmail();
		      }
		   });

		      
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
		    	  protected void sendEmail() {
		    	      Log.i("Trimite e-mail", "");

		    	      String[] TO = {"andrei.delia@hp.com"};
		    	      String[] CC = {"bogdan@thoreb.com.com"};
		    	      Intent emailIntent = new Intent(Intent.ACTION_SEND);
		    	      emailIntent.setData(Uri.parse("mailto:"));
		    	      emailIntent.setType("text/plain");


		    	      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
		    	      emailIntent.putExtra(Intent.EXTRA_CC, CC);
		    	      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subiect");
		    	      emailIntent.putExtra(Intent.EXTRA_TEXT, "Mesajul dumneavoastra");

		    	      try {
		    	         startActivity(Intent.createChooser(emailIntent, "Trimite e-mail..."));
		    	         finish();
		    	         Log.i("Finalizare trimitere e-mail...", "");
		    	      } catch (android.content.ActivityNotFoundException ex) {
		    	         Toast.makeText(DespreActivity.this, 
		    	         "Nu exista client de e-mail instalat.", Toast.LENGTH_SHORT).show();
		    	      }
		    	   }
		    	   
	
	}

	

