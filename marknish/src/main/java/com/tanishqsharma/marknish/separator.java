package com.tanishqsharma.marknish;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by tanishqsharma on 09/11/17.
 */

public class separator extends android.view.View {
    public separator(Context context) {
        super(context);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5));
        this.setBackgroundColor(Color.parseColor("#383838"));
    }
}
