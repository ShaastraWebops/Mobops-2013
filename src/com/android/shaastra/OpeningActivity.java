package com.android.shaastra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OpeningActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button events = (Button) findViewById(R.id.events_button);
        events.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(OpeningActivity.this, EventsGallery.class));
			}
		});
        
        Button coords = (Button) findViewById(R.id.coords_button);
        coords.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(OpeningActivity.this, CoOrdinatorList.class));
			}
		});
        
        Button hospi = (Button) findViewById(R.id.hospi_button);
        hospi.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(OpeningActivity.this, Hospitality.class));
			}
		});
        
        Button spons = (Button) findViewById(R.id.spons_button);
        spons.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(OpeningActivity.this, Sponsors.class));
			}
		});
    }
}