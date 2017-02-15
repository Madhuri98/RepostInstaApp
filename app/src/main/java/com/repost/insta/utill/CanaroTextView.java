package com.repost.insta.utill;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.repost.insta.InstaMyApp;

/**
 * Created by Niyati on 12/16/2016.
 */
public class CanaroTextView extends TextView {
    public CanaroTextView(Context context){
        this(context,null);
    }
    public CanaroTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(InstaMyApp.canaroExtraBold);
    }

    public CanaroTextView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }
}