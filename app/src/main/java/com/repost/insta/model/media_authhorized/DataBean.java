package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niyati on 2/10/2017.
 */
public class DataBean {
    /**
     * from : {"id":"4273988829","profile_picture":"https://scontent-fra3-1.cdninstagram.com/t51.2885-19/11906329_960233084022564_1448528159_a.jpg","full_name":"Jinh","username":"jinh3622"}
     * id : 17867679049013907
     * created_time : 1481904356
     * text : Yeah
     */

    @SerializedName("from")
    private FromBean from;
    @SerializedName("id")
    private String id;
    @SerializedName("created_time")
    private String createdTime;
    @SerializedName("text")
    private String text;

    public FromBean getFrom() {
        return from;
    }

    public void setFrom(FromBean from) {
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
