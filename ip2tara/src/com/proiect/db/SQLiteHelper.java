package com.proiect.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	private static String DB_PATH = "/data/data/com.proiect.ip2tara/databases/";
	private static String DB_NAME = "locations.db";
	private SQLiteDatabase myDataBase;
	private final Context myContext;

	public static final String TABLE_GEO_IP = "geo_ip";
	public static final String GEO_IP_ID = "_id";
	public static final String GEO_IP_START = "start";
	public static final String GEO_IP_END = "end";
	public static final String GEO_IP_COUNTRY = "country";

	// private static final String DATABASE_NAME = "locations.db";
	private static final int DATABASE_VERSION = 8;

	// Database creation sql statement
	/*
	 * private static final String DATABASE_CREATE_GEO_IP = "" + "create table "
	 * + TABLE_GEO_IP + "(" + GEO_IP_ID + " integer primary key autoincrement, "
	 * + GEO_IP_START + " integer not null, " + GEO_IP_END +
	 * " integer not null, " + GEO_IP_COUNTRY +
	 * " text not null default 'N/A');";
	 */

	public SQLiteHelper(Context context) {
		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	public void createDataBase() throws IOException {
//		dropDatabase();
		boolean dbExist = checkDataBase();
		if (dbExist) {
			// do nothing - database already exist
		} else {
			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are gonna be able to overwrite that
			// database with our database.
			this.getReadableDatabase();
			try {
				copyDataBase();
			} catch (IOException e) {
				throw new Error("Error copying database");
			}
		}
	}

	@Override
	public void onCreate(SQLiteDatabase database) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Log.w(SQLiteHelper.class.getName(),
		// "Upgrading database from version "
		// + oldVersion + " to " + newVersion
		// + ", which will destroy all old data");
		// db.execSQL("DROP TABLE IF EXISTS " + TABLE_GEO_IP);
		// onCreate(db);
		dropDatabase();
	}

	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.

		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}
	
	private void dropDatabase(){
		String outFileName = DB_PATH + DB_NAME;
		File file = new File(outFileName);
		if(file.exists()){
			file.delete();
		}
	}

	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public void openDataBase() throws SQLException {

		// Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);

	}

	@Override
	public synchronized void close() {
		if (myDataBase != null)
			myDataBase.close();
		super.close();
	}
}
