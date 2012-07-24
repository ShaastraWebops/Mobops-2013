package com.android.views;

import android.R.color;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class IconifiedTextView extends LinearLayout
{

	private TextView mText;
	private TextView tText;
	private ImageView mIcon;
	private TableLayout tab;
	private TableRow t;
	private TableRow v;

	public IconifiedTextView(Context context, IconifiedText aIconifiedText)
	{
		super(context);
		Resources r = getResources();
		float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, r.getDisplayMetrics());

		this.setOrientation(HORIZONTAL);
		// this.setLayoutParams(new
		// LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		tab = new TableLayout(context);
		tab.setLayoutParams(new LinearLayout.LayoutParams(85 * (int) px, 18 * (int) px));
		t = new TableRow(context);
		v = new TableRow(context);
		this.setBackgroundColor(color.transparent);

		mIcon = new ImageView(context);
		mIcon.setImageDrawable(aIconifiedText.getIcon());
		mIcon.setScaleType(ImageView.ScaleType.FIT_XY);
		// left, top, right, bottom

		mIcon.setPadding(0, (int) px, (int) px, (int) px); // 5px to the right
		mIcon.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		/*
		 * At first, add the Icon to ourself (! we are extending LinearLayout)
		 */
		// addView(mIcon, new LinearLayout.LayoutParams(
		// LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		this.addView(mIcon, 17 * (int) px, 18 * (int) px);
		TextView dummy = new TextView(context);
		dummy.setTextColor(0xFFFFFFFF);
		// mText.setShadowLayer((int)px,(int)px,(int)px,0xff000000);
		dummy.setTextSize(15f);
		dummy.setTypeface(Typeface.DEFAULT_BOLD);
		dummy.setPadding(0, 2 * (int) px, 0, 2 * (int) px);
		dummy.setGravity(Gravity.CENTER_VERTICAL);
		// mText.setWidth(60*(int)px);
		t.addView(dummy, 40 * (int) px, 2 * (int) px);
		tab.addView(t);
		mText = new TextView(context);
		mText.setTextColor(0xFFFFFFFF);
		// mText.setShadowLayer((int)px,(int)px,(int)px,0xff000000);
		mText.setTextSize(15f);
		mText.setTypeface(Typeface.DEFAULT_BOLD);
		mText.setPadding(0, 2 * (int) px, 0, 2 * (int) px);
		mText.setGravity(Gravity.CENTER_VERTICAL);
		// mText.setWidth(60*(int)px);
		// mText.setHeight(19*(int)px);
		mText.setText(aIconifiedText.getText());
		// this.addView(mText, 30*(int)px,10*(int)px);

		v.addView(mText, 40 * (int) px, 10 * (int) px);
		v.setBackgroundColor(color.white);
		tab.addView(v);
		this.addView(tab, 65 * (int) px, 19 * (int) px);
		// this.addView(mText, 20*(int)px, 20*(int)px);
		tText = new TextView(context);

		tText.setTextColor(0xFFFFFFFF);
		// tText.setShadowLayer((int)px,(int)px,(int)px,0xff000000);
		tText.setTextSize(12f);
		tText.setWidth(25 * (int) px);
		tText.setTypeface(Typeface.SERIF);

		tText.setGravity(Gravity.TOP);
		tText.setText(aIconifiedText.getTime());

		// Now the text (after the icon)
		this.addView(tText, 25 * (int) px, 10 * (int) px);
		// tab.addView(t);
		// tab.addView(v);
		// this.addView(tab);
		// this.addView(tText, 20*(int)px, 20*(int)px);

	}

	public void setText(String words)
	{
		mText.setText(words);
	}

	public void setTime(String words)
	{
		tText.setText(words);
	}

	public void setIcon(Drawable bullet)
	{
		mIcon.setImageDrawable(bullet);
	}
}