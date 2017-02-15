package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Niyati on 2/10/2017.
 */
public class CommentsBean {
    /**
     * data : [{"from":{"id":"4273988829","profile_picture":"https://scontent-fra3-1.cdninstagram.com/t51.2885-19/11906329_960233084022564_1448528159_a.jpg","full_name":"Jinh","username":"jinh3622"},"id":"17867679049013907","created_time":"1481904356","text":"Yeah"},{"from":{"id":"2521164587","profile_picture":"https://ig-s-c-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/15877293_1873554502879142_2784824548111941632_n.jpg","full_name":"Muddy Shutter Media Group, LLC","username":"muddyshuttermedia"},"id":"17867518447033752","created_time":"1481926332","text":"Cool!"},{"from":{"id":"3108948367","profile_picture":"https://ig-s-d-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/16465725_1170512113066815_4658148669692837888_a.jpg","full_name":"♥Mohade3_r♥","username":"mohadeseh.r.2015"},"id":"17857191034104825","created_time":"1482050173","text":"Goood"},{"from":{"id":"1127824110","profile_picture":"https://ig-s-c-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/10903701_750948654981398_1273883729_a.jpg","full_name":"Gazanini Bascombe","username":"gazaninibascombe"},"id":"17856613357094456","created_time":"1483255920","text":"N.."}]
     * count : 6
     */

    @SerializedName("count")
    private int count;
    @SerializedName("data")
    private List<DataBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
