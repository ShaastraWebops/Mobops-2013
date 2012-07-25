package com.android.helpers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class HTTPHelper {
	public static String postData(String url, JSONObject obj) {
		// Create a new HttpClient and Post Header

		try {
			Log.d("DATA SENT", obj.toString() + "\n" + url
					+ getResponseCode(url));
		} catch (MalformedURLException e1) {
			Log.d("failed", "URL is invalid");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpClient httpclient = new DefaultHttpClient();
		HttpParams myParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(myParams, 5000);
		HttpConnectionParams.setSoTimeout(myParams, 5000);
		String json = obj.toString();
		String temp = "";
		try {

			HttpPost httppost = new HttpPost(url.toString());
			httppost.setHeader("Content-type", "application/json");

			StringEntity se = new StringEntity(json);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json"));
			httppost.setEntity(se);

			HttpResponse response = null;
			try {
				response = httpclient.execute(httppost);
			} catch (Exception e) {
				Log.d("Failed", "Invalid URL");
				return "null";
			}
			temp = EntityUtils.toString(response.getEntity());

			// Checking the status of the server
			Log.i("Successful Response", temp);

		} catch (ClientProtocolException e) {

		} catch (IOException e) {
		}
		return temp;
	}

	public static String postData(String url, JSONArray obj) {
		try {
			Log.d("DATA SENT", obj.toString() + "\n" + url
					+ getResponseCode(url));
		} catch (MalformedURLException e1) {
			Log.d("failed", "URL is invalid");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpClient httpclient = new DefaultHttpClient();
		HttpParams myParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(myParams, 5000);
		HttpConnectionParams.setSoTimeout(myParams, 5000);

		String json = obj.toString();
		String temp = "";
		try {

			HttpPost httppost = new HttpPost(url);
			httppost.setHeader("Content-type", "application/json");

			StringEntity se = new StringEntity(json);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json"));
			httppost.setEntity(se);

			HttpResponse response = null;
			try {
				response = httpclient.execute(httppost);
			} catch (Exception e) {
				Log.d("Failed", "Invalid URL");
				return "null";
			}
			temp = EntityUtils.toString(response.getEntity());
			// Checking the status of the server
			Log.i("Successful Response", temp);

		} catch (ClientProtocolException e) {

		} catch (IOException e) {
		}
		return temp;
	}

	public static int getResponseCode(String urlString)
			throws MalformedURLException, IOException {
		URL u = new URL(urlString);
		HttpURLConnection huc = (HttpURLConnection) u.openConnection();
		huc.setRequestMethod("GET");
		huc.setRequestProperty(
				"User-Agent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
		huc.connect();
		return huc.getResponseCode();
	}
}

/*
 * public String getInternetData() throws Exception { BufferedReader in = null;
 * String data = null; try { HttpGet request = new HttpGet();
 * request.setURI(website); HttpResponse response = client.execute(request); in
 * = new BufferedReader(new
 * InputStreamReader(response.getEntity().getContent())); StringBuffer sb = new
 * StringBuffer(""); String l = ""; String nl =
 * System.getProperty("line.separator");
 * 
 * } }
 */
