package com.repost.insta.utill;

import android.content.Context;
import android.content.SharedPreferences;
import com.repost.insta.constant.Constant;

/**
 * Created by 9Brainz on 2/8/2017.
 */

public class SessionManager {
    public static final String PREF_NAME = "Instagram";
    private int PRIVATE_MODE = 0;
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    public Context _context;

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setUserProfilePic(String profileUrl) {
        editor.putString(Constant.KEY_PROFILE_PICTURE, profileUrl);
        editor.commit();
    }

    public String getUserProfilePic() {
        return pref.getString(Constant.KEY_PROFILE_PICTURE, "");
    }

}
