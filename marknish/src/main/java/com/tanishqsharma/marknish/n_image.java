package com.tanishqsharma.marknish;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tanishqsharma.marknish.helper.ImageLoader;


@SuppressLint("ViewConstructor")
public class n_image extends android.support.v7.widget.AppCompatImageView {

    public n_image(Context context, String url) {
        super(context);
        this.setLayoutParams(new LinearLayout.LayoutParams(1000, 1000));
        Toast.makeText(context, "" + url, Toast.LENGTH_SHORT).show();
        new ImageLoader(this).execute(url);

    }
}
