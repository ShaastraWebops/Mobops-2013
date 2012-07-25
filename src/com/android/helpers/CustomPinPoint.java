/*
 * Author : Abhiram Ravi, 
 * 			2nd yr Undergraduate, 
 * 			Dept of CSE, 
 * 			IIT Madras.
 * 			abhiram.supersaiyan@gmail.com
 * Start Date : May 9th, 2012
 * Updated on : May 16th, 2012
 * 
 * Intern at CheckSum Infosoft Pvt. Ltd.
 * 
 * The custom pin point overlay item - marker for the maps 
 * 
 * */
package com.android.helpers;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class CustomPinPoint extends ItemizedOverlay<OverlayItem>
{
	private ArrayList<OverlayItem> pinpoints = new ArrayList<OverlayItem>();
	private Context c;
	
	public CustomPinPoint(Drawable defaultMarker) 
	{
		super(boundCenter(defaultMarker));
	}
	public CustomPinPoint(Drawable m, Context c) 
	{
		this(m);
		this.c = c;
	}

	@Override
	protected OverlayItem createItem(int i) 
	{
		return pinpoints.get(i);
	}

	@Override
	public int size() 
	{
		return pinpoints.size();
	}
	public void insertPinPoint(OverlayItem item)
	{
		pinpoints.add(item);
		this.populate();
	}
}
