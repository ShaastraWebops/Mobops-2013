package com.android.shaastra;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class EventsInformation extends Activity
{
	/* The event ID obtained from the intent */
	public String eventID;

	/* The information obtained from the databases */
	public String eventTitle;
	public String eventPrizeMoney;
	public String introductionText;
	public String eventFormatText;
	public String venueText;
	public double venueLat;
	public double venueLong;
	
	public ViewFlipper vf;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_information);

		//eventID = getIntent().getExtras().getString("eventID");
		getInfoFromDatabase();
		setEventTitle();
		setEventImage();
		setPrizeMoney();
		setFlipper();
		setActionListenersForButtons();
		
		
		

	}
	public void getInfoFromDatabase()
	{
		eventTitle = "This is a really long event name";
		eventPrizeMoney = "45000";
		introductionText = "This is the introduction text\n If this works fine, then we can safely abstract this section of the code";
		eventFormatText = "This is the event format text";
		venueText = "This is the venue text";
		
		//TODO : Obtain from database
	}
	public void setEventTitle()
	{
		TextView tv = (TextView) findViewById(R.id.eventTitle);
		tv.setText(eventTitle);
	}

	public void setEventImage()
	{
		ImageView iv = (ImageView) findViewById(R.id.event_image);
		// iv.setImage();
	}

	public void setPrizeMoney()
	{
		Button b = (Button) findViewById(R.id.prizeMoney);
		b.setText("Prize Money:\n Rs. " + eventPrizeMoney);
	}

	public void setFlipper()
	{
		vf = (ViewFlipper) findViewById(R.id.flipper);
		LayoutInflater li = LayoutInflater.from(this);
		
		/* The introduction view */
		View introduction = li.inflate(R.layout.event_desciption_inflate, null);
		TextView tb = (TextView) introduction.findViewById(R.id.tablabel2);
		tb.setText("Introduction");
		TextView tv = (TextView) introduction.findViewById(R.id.description);
		tv.setText(introductionText);
		Button b = (Button) introduction.findViewById(R.id.viewOnMap);
		b.setVisibility(View.INVISIBLE);
		
		/* The Event Format View */
		View eventFormat = li.inflate(R.layout.event_desciption_inflate, null);
		TextView tb2 = (TextView) eventFormat.findViewById(R.id.tablabel2);
		tb2.setText("Event Format");
		TextView tv2 = (TextView) eventFormat.findViewById(R.id.description);
		tv2.setText(eventFormatText);
		Button b2 = (Button) eventFormat.findViewById(R.id.viewOnMap);
		b2.setVisibility(View.INVISIBLE);
		
		/* The Venue and Maps View */
		View venue = li.inflate(R.layout.event_desciption_inflate, null);
		TextView tb3 = (TextView) venue.findViewById(R.id.tablabel2);
		tb3.setText("Venue");
		TextView tv3 = (TextView) venue.findViewById(R.id.description);
		tv3.setText(venueText);
		Button b3 = (Button) venue.findViewById(R.id.viewOnMap);
		b3.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Log.d("MAP INITIATE", "This initiates the map");
				/*	
				Intent i = new Intent(EventsInformation.this, Maps.class);
				i.putExtra("Latitude", venueLat);
				i.putExtra("Longitude", venueLong);
				startActivity(i);
				*/
			}
		});
		/* Adding these to the flipper */
		vf.addView(introduction);
		vf.addView(eventFormat);
		vf.addView(venue);
		vf.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
		vf.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
		
		vf.setDisplayedChild(0);
		//vf.setFlipInterval(3000);
		//vf.startFlipping();
	}
	public void setActionListenersForButtons()
	{
		Button intro = (Button) findViewById(R.id.intro);
		intro.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				vf.setDisplayedChild(0);
			}
		});
		
		Button format = (Button) findViewById(R.id.eventFormat);
		format.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				vf.setDisplayedChild(1);
			}
		});
		
		Button venue = (Button) findViewById(R.id.venueAndMaps);
		venue.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				vf.setDisplayedChild(2);
			}
		});
	}

}
