package com.proiect.ip2tara;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.proiect.db.GeoIPDataSource;

import android.os.AsyncTask;

public class GetExternalIPAsync extends AsyncTask<String, Integer, String> {
	
	String ip;

	@Override
	protected String doInBackground(String... params) {
		
		String remoteurl = "http://wtfismyip.com/text";
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(remoteurl);
			HttpResponse response;
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				long len = entity.getContentLength();
				if (len != -1 && len < 1024) {
					String str = EntityUtils.toString(entity);
					// Log.i("externalip",str);
					ip = str;
				} else {
					ip = "Response too long or error.";
				}
			} else {
				ip = "Null:" + response.getStatusLine().toString();
			}

		} catch (Exception e) {
			ip = "Error";
		}
		return ip.trim();
	}
}
