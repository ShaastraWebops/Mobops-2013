package com.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

public class SlowGallery extends Gallery {

	public SlowGallery(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
	}
	public SlowGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}
	public SlowGallery(Context context) {
		super(context);
		
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return super.onFling(e1, e2, velocityX/2, velocityY);
	}
	

}
