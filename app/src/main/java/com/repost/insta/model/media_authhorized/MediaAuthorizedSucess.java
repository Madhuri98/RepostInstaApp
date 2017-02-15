package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 9Brainz on 2/8/2017.
 */

public class MediaAuthorizedSucess {

    @SerializedName("status")
    private String status;
    @SerializedName("more_available")
    private boolean moreAvailable;
    @SerializedName("items")
    private List<ItemsBean> items;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isMoreAvailable() {
        return moreAvailable;
    }

    public void setMoreAvailable(boolean moreAvailable) {
        this.moreAvailable = moreAvailable;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }
}
