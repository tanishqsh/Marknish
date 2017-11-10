package com.tanishqsharma.marknish.elements;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tanishqsharma.marknish.helper.ImageLoader;


@SuppressLint("ViewConstructor")
public class n_image extends android.support.v7.widget.AppCompatImageView {

    public n_image(Context context, String url) {
        super(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        /*
        Making sure the image is in the center
         */

        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        this.setLayoutParams(layoutParams);
        new ImageLoader(this).execute(url);

    }
}
