package com.android.views;


import com.android.shaastra.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageViewWithShadow extends LinearLayout {

	public ImageViewWithShadow(Context context) {
		this(context,null);
	
	}
	
	public ImageViewWithShadow(Context context, AttributeSet attrs) {
		this(context,attrs,0);
		
		// TODO Auto-generated constructor stub
	}
	public ImageViewWithShadow(Context context, AttributeSet attrs, int defstyle)
	{
		super(context);
	}

	protected void onDraw(Canvas canvas)
	{
		Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.involve);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		Paint borderPaint = new Paint();
		borderPaint.setStrokeWidth((float) 2.0);
		borderPaint.setStyle(Style.STROKE);
		borderPaint.setColor(Color.BLACK);
		
		paint.setShadowLayer(1.0f, 3.0f, 3.0f, Color.BLACK);
		canvas.drawColor(Color.GRAY);
		Bitmap bmp2 = Bitmap.createScaledBitmap(bmp, 100, 100, false);
		
		canvas.drawRect(20,20,bmp2.getWidth()+20,bmp2.getHeight()+20, paint);
		canvas.drawRect(20,20,bmp2.getWidth()+20,bmp2.getHeight()+20, borderPaint);
		canvas.drawBitmap(bmp2,20,20,null);
		super.onDraw(canvas);
		
		 
	}

}
