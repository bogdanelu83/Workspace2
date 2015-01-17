package com.proiect.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class GeoIPDataSource {
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	private String[] allColumns = { 
			SQLiteHelper.GEO_IP_ID,
			SQLiteHelper.GEO_IP_START, 
			SQLiteHelper.GEO_IP_END,
			SQLiteHelper.GEO_IP_COUNTRY };

	public GeoIPDataSource(Context context) {
		dbHelper = new SQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public void cretateRecord(int itart, int end, String country){
		
	}
	
	public String getCountryByIP(int IP){
		String query = "SELECT "
				+ SQLiteHelper.GEO_IP_ID + ", " 
				+ SQLiteHelper.GEO_IP_START + ", " 
				+ SQLiteHelper.GEO_IP_END + ", " 
				+ SQLiteHelper.GEO_IP_COUNTRY + " "
				+ " FROM " + SQLiteHelper.TABLE_GEO_IP + " WHERE " + String.valueOf(IP) + " "
						+ "BETWEEN " + SQLiteHelper.GEO_IP_START + " AND " + SQLiteHelper.GEO_IP_END 
						+ " LIMIT 1";
		Cursor cursor = database.rawQuery(query , null);
		cursor.moveToFirst();
		String record = cursorToLocationRecord(cursor).getCountry();
		cursor.close();
		return record;
	}
	
	private GeoIP cursorToLocationRecord(Cursor cursor) {
		GeoIP geoIP = new GeoIP();
		geoIP.setId(cursor.getInt(0));
		geoIP.setStart(cursor.getInt(1));
		geoIP.setEnd(cursor.getInt(2));
		geoIP.setCountry(cursor.getString(3));
		return geoIP;
	}
}
