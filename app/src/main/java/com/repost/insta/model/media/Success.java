package com.repost.insta.model.media;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niyati on 2/7/2017.
 */

public class Success {
    @SerializedName("provider_url")
    private String provider_url;
    @SerializedName("thumbnail_height")
    private int thumbnail_height;
    @SerializedName("thumbnail_width")
    private int thumbnail_width;
    @SerializedName("width")
    private int width;
    @SerializedName("provider_name")
    private String provider_name;
    @SerializedName("type")
    private String type;
    @SerializedName("version")
    private String version;
    @SerializedName("author_id")
    private String author_id;
    @SerializedName("author_name")
    private String author_name;
    @SerializedName("author_url")
    private String author_url;
    @SerializedName("media_id")
    private String media_id;
    @SerializedName("thumbnail_url")
    private String thumbnail_url;
    @SerializedName("height")
    private String height;

    public String getProvider_url() {
        return provider_url;
    }

    public void setProvider_url(String provider_url) {
        this.provider_url = provider_url;
    }

    public int getThumbnail_height() {
        return thumbnail_height;
    }

    public void setThumbnail_height(int thumbnail_height) {
        this.thumbnail_height = thumbnail_height;
    }

    public int getThumbnail_width() {
        return thumbnail_width;
    }

    public void setThumbnail_width(int thumbnail_width) {
        this.thumbnail_width = thumbnail_width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
