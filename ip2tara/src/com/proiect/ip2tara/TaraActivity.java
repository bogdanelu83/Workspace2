package com.proiect.ip2tara;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.proiect.ip2tara.TaraActivity.CountryColumns;

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
public class TaraActivity extends Activity {

	//definire TAG
	 public static String TAG="country";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tara);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tara, menu);
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
	
	
	
	
	
	//Tabela Tari
    public static final class CountryColumns implements BaseColumns {
     
        private CountryColumns () {}
      
        public static final String TARI = "tari";
      
   
        public static final String COUNTRYCODE = "countryCode";        
        public static final String COUNTRYNAME = "countryName";
        public static final String CURRENCYCODE = "currencyCode";
        public static final String POPULATION = "population";
        public static final String CAPITAL = "capital";
        public static final String CONTINENTNAME = "continentName";
      
    }
    
      

    
    //clasa pentru deschidere, creare si upgradare database
   
   private static class BDHelper extends SQLiteOpenHelper {
        
       private final Context fContext;
        
       BDHelper(Context context) {
           super(context, "Tari", null, 1);
           fContext = context;
       } 
    
       @Override
       public void onCreate(SQLiteDatabase db) {
           db.execSQL("CREARE TABELA tari ("
                   + "_id INTEGER PRIMARY KEY,"
                   + "countryCode TEXT,"
                   + "countryName TEXT,"
                   + "currencyCode TEXT,"
                   + "population TEXT,"
                   + "capital TEXT,"
                   + "continentName TEXT"                 
                   + ");");
    
           //adaugare tari
           ContentValues _Values = new ContentValues(); 
           
           //preluare din fisier xml
           Resources res = fContext.getResources();
            
           //deschidere fisier xml
           XmlResourceParser _xml = res.getXml(R.xml.tari);
           try
           {
               //verific sfarsitul documentului
               int eventType = _xml.getEventType();
               while (eventType != XmlPullParser.END_DOCUMENT) {
                   //caut tag-urile
                   if ((eventType == XmlPullParser.START_TAG) &&(_xml.getName().equals("country"))){
                       //gasesc tag, inserez valori
                       String _CountryCode = _xml.getAttributeValue(null, CountryColumns.COUNTRYCODE);
                       String _CountryName = _xml.getAttributeValue(null, CountryColumns.COUNTRYNAME);
                       String _CurrencyCode = _xml.getAttributeValue(null, CountryColumns.CURRENCYCODE);
                       String _Population = _xml.getAttributeValue(null, CountryColumns.POPULATION);
                       String _Capital = _xml.getAttributeValue(null, CountryColumns.CAPITAL);
                       String _ContinentName = _xml.getAttributeValue(null, CountryColumns.CONTINENTNAME);
                   
                       
                       _Values.put(CountryColumns.COUNTRYCODE, _CountryCode);
                       _Values.put(CountryColumns.COUNTRYNAME, _CountryName);
                       _Values.put(CountryColumns.CURRENCYCODE, _Population);
                       _Values.put(CountryColumns.POPULATION, _CountryCode);
                       _Values.put(CountryColumns.CAPITAL, _Capital);
                       _Values.put(CountryColumns.CONTINENTNAME, _ContinentName);
                                              
                       
                       db.insert(CountryColumns.TARI, null, _Values);              

                   }
                   eventType = _xml.next();
               }
           }
           //detectare erori
           catch (XmlPullParserException e)
           {       
               Log.e(TAG, e.getMessage(), e);
           }
           catch (IOException e)
           {
               Log.e(TAG, e.getMessage(), e);
                
           }           
           finally
           {           
               //inchidere fisier xml
               _xml.close();
           }
       }
    
       //updatare database
       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           
                        
           Log.w(TAG, "upgradare databse din versiunea " + oldVersion + " in "
                   + newVersion + ", care va sterge datele precedente");
           db.execSQL("DROP TABLE IF EXISTS tari");
           onCreate(db);
       }
}
   
}
