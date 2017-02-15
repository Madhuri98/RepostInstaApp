package com.repost.insta.interfaces;

import com.repost.insta.model.media.Success;
import com.repost.insta.model.media_authhorized.MediaAuthorizedSucess;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Niyati on 2/7/2017.
 */

public interface RequestInterface {

    @GET
    Call<Success> getData(@Url String url);

    @GET
    Call<MediaAuthorizedSucess> getPost(@Url String url);

}
