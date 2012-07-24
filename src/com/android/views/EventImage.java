package com.android.views;

import java.util.List;

import com.android.shaastra.R;




import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class EventImage extends RelativeLayout {
	public ImageView eventImage;
	public TextView	eventNameView;
	private static final  String SUPERSTATE = " superstate";
	private static final String IMAGEID = "imageid";
	private static final String EVENTNAME = "eventname";
	private int imageId;
	private String eventName;
	
	public EventImage(Context context)
	{
		this(context,null);
	//	this.setOrientation(VERTICAL);
	}
	public EventImage(Context context,AttributeSet attrs)
	{
		super(context,attrs);
		((Activity)getContext()).getLayoutInflater().inflate(R.layout.image_holder, this, true);
		eventImage = (ImageView) findViewById(R.id.image);
		eventNameView = (TextView) findViewById(R.id.eventName);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		eventImage.setLayoutParams(layoutParams);
		
	    this.setBackgroundColor(Color.BLACK);
	//	this.setOrientation(VERTICAL);
		if(attrs!=null)
		{
			TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.EventImage,0,0);
			imageId = a.getResourceId(R.styleable.EventImage_event_image, 0);
			eventImage.setImageResource(imageId);
			
			eventName = a.getString(R.styleable.EventImage_eventname);
			eventNameView.setText(eventName);
		}
	}
	
	public void setImageResource(Integer integer) {
	eventImage.setImageResource(integer);
	}
	
	public Parcelable onSaveInstanceState()
	{
		Bundle state = new Bundle();
		state.putParcelable(SUPERSTATE, super.onSaveInstanceState());
		state.putInt(IMAGEID, imageId);
		state.putString(EVENTNAME,eventName);
		return state;
	}
	public void onRestoreInstanceState(Parcelable ss)
	{
		Bundle state = (Bundle)ss;
		super.onRestoreInstanceState(state.getParcelable(SUPERSTATE));
		eventNameView.setText(state.getString(EVENTNAME));
		eventImage.setImageResource(state.getInt(IMAGEID));
	}
	
}