package com.tanishqsharma.marknish.elements;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Returns the bullet element
 */

public class n_bullet extends android.support.v7.widget.AppCompatTextView{

    String bullet = "\u2022";


    public n_bullet(Context context, String text) {
        super(context);
        int padding = 20;
        this.setTextColor(Color.parseColor("#383838"));
        this.setGravity(Gravity.CENTER_VERTICAL);
        this.setPadding(padding, padding, padding, padding);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.setTextSize(18);
        this.setText(bullet.concat(text));
    }
}
