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


@SuppressWarnings("unused")
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

	

