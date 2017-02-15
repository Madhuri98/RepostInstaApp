package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niyati on 2/10/2017.
 */
public class LowResolutionBean {
    /**
     * width : 480
     * height : 480
     * url : https://scontent-lhr3-1.cdninstagram.com/t50.2886-16/15592788_217810655337899_8851588427783602176_n.mp4
     */

    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("url")
    private String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
