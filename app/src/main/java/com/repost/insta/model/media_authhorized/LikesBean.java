package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Niyati on 2/10/2017.
 */
public class LikesBean {
    /**
     * data : [{"id":"575216177","profile_picture":"https://ig-s-a-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/15538713_354208121638584_6701096868157325312_a.jpg","full_name":"Jaasiel Luna","username":"jaasiel_photo_and_art"},{"id":"1731351335","profile_picture":"https://ig-s-d-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/12940218_1558011974496307_805563892_a.jpg","full_name":"Cake in a Crate","username":"cakeinacrate"},{"id":"239171182","profile_picture":"https://ig-s-b-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/14591082_1185831858173329_4191019986401099776_a.jpg","full_name":"SR Artwork","username":"srartwork"},{"id":"3612123871","profile_picture":"https://ig-s-a-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/13736883_652186524933756_1490197376_a.jpg","full_name":"Bekah Miller","username":"r_millerca"}]
     * count : 454
     */

    @SerializedName("count")
    private int count;
    @SerializedName("data")
    private List<DataBeanX> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }
}
