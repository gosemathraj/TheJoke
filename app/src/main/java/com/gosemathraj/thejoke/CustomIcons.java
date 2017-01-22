package com.gosemathraj.thejoke;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by iamsparsh on 20/1/17.
 */

public class CustomIcons extends TextView {
    public CustomIcons(Context context) {
        super(context);
        setFont(context);
    }

    public CustomIcons(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomIcons(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomIcons(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFont(context);
    }

    public void setFont(Context context){
        Typeface face=Typeface.createFromAsset(context.getAssets(),
                "icomoon.ttf");
        setTypeface(face);
    }
}
