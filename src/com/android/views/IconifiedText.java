package com.android.views;

import android.graphics.drawable.Drawable;

/** @author Steven Osborn - <!-- m --><a class="postlink" href="http://steven.bitsetters.com">http://steven.bitsetters.com</a><!-- m --> */

public class IconifiedText implements Comparable<IconifiedText>{
    
	private String mText = "";
	private String mtime ="";
	private Drawable mIcon;
	private boolean mSelectable = true;
  
	public IconifiedText(String text,String time, Drawable bullet) {
		mIcon = bullet;
		mText = text;
		mtime=time;
	}
	
	public boolean isSelectable() {
		return mSelectable;
	}
	
	public void setSelectable(boolean selectable) {
		mSelectable = selectable;
	}
	
	public String getTime() {
		return mtime;
	}
	
	public void setTime(String text) {
		mtime = text;
	}
	public String getText() {
		return mText;
	}
	
	public void setText(String text) {
		mText = text;
	}
	
	public void setIcon(Drawable icon) {
		mIcon = icon;
	}
	
	public Drawable getIcon() {
		return mIcon;
	}

	/** Make IconifiedText comparable by its name */
	@Override
	public int compareTo(IconifiedText other) {
		if(this.mText != null)
			return this.mText.compareTo(other.getText()); 
		else 
			throw new IllegalArgumentException();
	}
}