package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niyati on 2/10/2017.
 */
public class CaptionBean {
    /**
     * from : {"id":"280084457","profile_picture":"https://ig-s-c-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/12547278_1670388409897754_59931543_a.jpg","full_name":"Marc Morgan","username":"vanilluh_gorilluh"}
     * id : 17871414412028848
     * created_time : 1481848484
     * text : Tbt Bts again! Here are some unedited videos from a year ago that a few of you have asked to see! Got some new nickelodeon videos coming up and some of my own stuff as well so be ready and thanks for watching! #tbt #bts #throwbackthursday #stopmotion #behindthescenes #claymation #animation #stopmotion #greenscreen #drums #redbull #wizardofoz #twentyonepilots #time
     */

    @SerializedName("from")
    private FromBeanX from;
    @SerializedName("id")
    private String id;
    @SerializedName("created_time")
    private String createdTime;
    @SerializedName("text")
    private String text;

    public FromBeanX getFrom() {
        return from;
    }

    public void setFrom(FromBeanX from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
