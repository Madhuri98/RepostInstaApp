package com.repost.insta;

import android.app.Application;
import android.graphics.Typeface;

import com.flurry.android.FlurryAgent;
import com.onesignal.OneSignal;

/**
 * Created by 9Brainz on 2/11/2017.
 */

public class InstaMyApp extends Application {

    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this).init();
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.init(this, "9SVNJGB3N5XVB46C2Q2J");
        initTypeface();
    }

    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(),CANARO_EXTRA_BOLD_PATH);
    }

}
