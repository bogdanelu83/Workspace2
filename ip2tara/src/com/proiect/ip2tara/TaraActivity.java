package com.proiect.ip2tara;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class TaraActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tara);
		final Activity activity = this;
		WebView webview = (WebView)findViewById(R.id.webView);
		Bundle bundle = getIntent().getExtras();
		if (bundle.getString("COUNTRY") != null) {
			//WebView webview = new WebView(this);
//			webview.setWebChromeClient(new WebChromeClient() {
//				public void onProgressChanged(WebView view, int progress) {
//					// Activities and WebViews measure progress with different
//					// scales.
//					// The progress meter will automatically disappear when we
//					// reach 100%
//					activity.setProgress(progress * 1000);
//				}
//			});
//			webview.setWebViewClient(new WebViewClient() {
//				public void onReceivedError(WebView view, int errorCode,
//						String description, String failingUrl) {
//					Toast.makeText(activity, "Oh no! " + description,
//							Toast.LENGTH_SHORT).show();
//				}
//			});

			webview.loadUrl("http://en.wikipedia.org/wiki/"
					+ bundle.getString("COUNTRY"));
			//setContentView(webview);
			// wv.loadUrl("http://en.wikipedia.org/wiki/" +
			// bundle.getString("COUNTRY"));
		}
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
}
