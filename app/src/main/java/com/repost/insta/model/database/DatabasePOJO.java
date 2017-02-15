package com.repost.insta.model.database;

/**
 * Created by Niyati on 2/9/2017.
 */

public class DatabasePOJO {

    private int id;
    private String author;
    private String description;
    private String photo;
    private String mediaID;
    private String authorFullname;
    private String authorPhoto;
    private String video;
    private String isVideo;
    private String thumb;

    public DatabasePOJO(){
    }
    public DatabasePOJO(int id, String author, String description, String photo, String mediaID, String authorFullname, String authorPhoto, String video, String isVideo, String thumb) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.photo = photo;
        this.mediaID = mediaID;
        this.authorFullname = authorFullname;
        this.authorPhoto = authorPhoto;
        this.video = video;
        this.isVideo = isVideo;
        this.thumb = thumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

    public String getAuthorFullname() {
        return authorFullname;
    }

    public void setAuthorFullname(String authorFullname) {
        this.authorFullname = authorFullname;
    }

    public String getAuthorPhoto() {
        return authorPhoto;
    }

    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(String isVideo) {
        this.isVideo = isVideo;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
