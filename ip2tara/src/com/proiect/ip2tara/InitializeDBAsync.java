package com.proiect.ip2tara;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.proiect.db.GeoIPDataSource;
import com.proiect.db.SQLiteHelper;

import android.app.Application;
import android.content.Context;
import android.database.SQLException;
import android.os.AsyncTask;

public class InitializeDBAsync extends AsyncTask<String, Integer, String> {
	Context context;

	public InitializeDBAsync(Context context) {
		super();
		this.context = context;
	}

	private GeoIPDataSource datasource;

	@Override
	protected String doInBackground(String... params) {
		SQLiteHelper myDbHelper = new SQLiteHelper(context);
		//myDbHelper = new SQLiteHelper(context);
		try {
			myDbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		try {
			myDbHelper.openDataBase();
		} catch (SQLException sqle) {
			throw sqle;
		}
//		datasource = new GeoIPDataSource(context);
//		datasource.open();
//		datasource.close();
		return "done";
	}
}
