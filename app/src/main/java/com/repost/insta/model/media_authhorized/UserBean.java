package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niyati on 2/10/2017.
 */
public class UserBean {
    /**
     * id : 280084457
     * profile_picture : https://ig-s-c-a.akamaihd.net/hphotos-ak-xfa1/t51.2885-19/s150x150/12547278_1670388409897754_59931543_a.jpg
     * full_name : Marc Morgan
     * username : vanilluh_gorilluh
     */

    @SerializedName("id")
    private String id;
    @SerializedName("profile_picture")
    private String profilePicture;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("username")
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
