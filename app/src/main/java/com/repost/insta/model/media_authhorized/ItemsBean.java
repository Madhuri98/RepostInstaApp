package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niyati on 2/10/2017.
 */
public class ItemsBean {

    @SerializedName("location")
    private Object location;
    @SerializedName("id")
    private String id;
    @SerializedName("created_time")
    private String createdTime;
    @SerializedName("comments")
    private CommentsBean comments;
    @SerializedName("alt_media_url")
    private String altMediaUrl;
    @SerializedName("can_view_comments")
    private boolean canViewComments;
    @SerializedName("type")
    private String type;
    @SerializedName("videos")
    private VideosBean videos;
    @SerializedName("link")
    private String link;
    @SerializedName("images")
    private ImagesBean images;
    @SerializedName("user_has_liked")
    private boolean userHasLiked;
    @SerializedName("caption")
    private CaptionBean caption;
    @SerializedName("user")
    private UserBean user;
    @SerializedName("code")
    private String code;
    @SerializedName("likes")
    private LikesBean likes;
    @SerializedName("can_delete_comments")
    private boolean canDeleteComments;

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
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

    public CommentsBean getComments() {
        return comments;
    }

    public void setComments(CommentsBean comments) {
        this.comments = comments;
    }

    public String getAltMediaUrl() {
        return altMediaUrl;
    }

    public void setAltMediaUrl(String altMediaUrl) {
        this.altMediaUrl = altMediaUrl;
    }

    public boolean isCanViewComments() {
        return canViewComments;
    }

    public void setCanViewComments(boolean canViewComments) {
        this.canViewComments = canViewComments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VideosBean getVideos() {
        return videos;
    }

    public void setVideos(VideosBean videos) {
        this.videos = videos;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public boolean isUserHasLiked() {
        return userHasLiked;
    }

    public void setUserHasLiked(boolean userHasLiked) {
        this.userHasLiked = userHasLiked;
    }

    public CaptionBean getCaption() {
        return caption;
    }

    public void setCaption(CaptionBean caption) {
        this.caption = caption;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LikesBean getLikes() {
        return likes;
    }

    public void setLikes(LikesBean likes) {
        this.likes = likes;
    }

    public boolean isCanDeleteComments() {
        return canDeleteComments;
    }

    public void setCanDeleteComments(boolean canDeleteComments) {
        this.canDeleteComments = canDeleteComments;
    }
}
