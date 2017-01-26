package com.gosemathraj.thejoke;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by iamsparsh on 23/1/17.
 */

public class CustomIconTextView extends TextView {
    public CustomIconTextView(Context context) {
        super(context);
        setFont(context);
    }

    public CustomIconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomIconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomIconTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFont(context);

    }

    public void setFont(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(),
                "icomoon.ttf");
        setTypeface(face);
    }
}
