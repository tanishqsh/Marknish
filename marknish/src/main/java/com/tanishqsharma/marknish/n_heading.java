package com.tanishqsharma.marknish;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Returns the heading element
 */

@SuppressLint("ViewConstructor")
public class n_heading extends android.support.v7.widget.AppCompatTextView{

    public n_heading(Context context, String text) {
        super(context);
        //Typeface poppins_bold = Typeface.createFromAsset(context.getResources().getAssets(), "font/pbold.ttf");
        int padding = 20;
        this.setTextColor(Color.parseColor("#383838"));
        this.setGravity(Gravity.CENTER_VERTICAL);
        this.setPadding(padding, padding, padding, padding);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.setTextSize(25);
        //this.setTypeface(poppins_bold);
        text = text.toUpperCase();
        this.setText(text);
    }
}
