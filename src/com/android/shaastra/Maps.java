
package com.android.shaastra;

import java.util.List;

import org.json.JSONException;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import com.android.helpers.CustomPinPoint;
import com.android.helpers.Global;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Maps extends MapActivity 
{
	
	/* The overlay list - though it will only contain one item in this context */
	List<Overlay> overlayList;
	
	/* The Google Map */
	MapView view;
	
	/* The Map Controller */
	MapController control;
	
	/* The Location Manager */
	LocationManager manager;
	
	/* Map Listener used to add to the location manager */
	LocationListener mapListener;
	
	/* Set the map zoom here */
	int mapZoom = Global.mapZoom;
	
	/* Just a debugging tool to display the lat long on the screen to confirm the GPS update */
	TextView tv;
	
	/* The drawable used to mark the points on the screen */
	Drawable d;
	
	long startTime;
	long endTime;
	boolean wait = false;
	
	
	double destLat;
	double destLong;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.map);
	    
	    tv = (TextView) findViewById(R.id.textView1);
	    view = (MapView) findViewById(R.id.themap);
	    view.setBuiltInZoomControls(true);
	    
	    /* The Map controller */
	    control = view.getController();	    
	    control.setZoom(mapZoom);
	    
	    /* the google map marker */
	    d = getResources().getDrawable(R.drawable.google_maps_marker);
	    
	    /* Setting the destination chosen */
	    destLat = getIntent().getExtras().getDouble("Latitude");
	    destLong = getIntent().getExtras().getDouble("Longitude");
	    
	    /* The touchy class - Actually the overlay class would have been sufficient, but this takes care of any future touch requests for operating the map :D */
	    Touchy t = new Touchy();
	    
	    /* Initializing the overlaylist */
		overlayList = view.getOverlays();
		overlayList.add(t);
	    
		/* Creating a location manager to manage GPS updates and setting the location listener */
	    manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
	    mapListener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			
			@Override
			public void onProviderEnabled(String provider) {}
			
			@Override
			public void onProviderDisabled(String provider) {}
			
			/*This is the important method - Executed when a location change is encountered - here it is executed every waitTime milliseconds */
			@Override
			public void onLocationChanged(Location location)
			{
				Location currentLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				GeoPoint current = new GeoPoint((int)((double)currentLocation.getLatitude()*1E6), (int)((double)currentLocation.getLongitude()*1E6));
				control.animateTo(current);
				
				/* Drawing the marker on the screen */
				OverlayItem overlayItem = new OverlayItem(current,"String 1", "String 2");
				CustomPinPoint cpp = new CustomPinPoint(d, Maps.this);
				cpp.insertPinPoint(overlayItem);
				overlayList.clear();
				overlayList.add(cpp);
				/* This line may cause problems on some devices - check it out */
				view.invalidate();
				
				
			}

			
		};
		
		/* Initializing the GPS update request */
		manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, Global.waitTime, 0, mapListener);
	}

	@Override
	protected boolean isRouteDisplayed() {return false;}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) 
	{
		switch(item.getItemId())
		{
		
		}
		return true;
	}
	/* 
	 * The touchy class to handle any touch events on the map 
	 * OnTouchEvent will be implemented when necessary 
	 * */
	class Touchy extends Overlay
	{
		public boolean onTouchEvent(MotionEvent e, MapView m)
		{
			return false;
		}
	}
}
