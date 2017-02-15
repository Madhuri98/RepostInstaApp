package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 9Brainz on 2/10/2017.
 */


public class VideosBean {

    @SerializedName("low_bandwidth")
    private LowBandwidthBean lowBandwidth;
    @SerializedName("low_resolution")
    private LowResolutionBean lowResolution;
    @SerializedName("standard_resolution")
    private StandardResolutionBean standardResolution;

    public LowBandwidthBean getLowBandwidth() {
        return lowBandwidth;
    }

    public void setLowBandwidth(LowBandwidthBean lowBandwidth) {
        this.lowBandwidth = lowBandwidth;
    }

    public LowResolutionBean getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(LowResolutionBean lowResolution) {
        this.lowResolution = lowResolution;
    }

    public StandardResolutionBean getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(StandardResolutionBean standardResolution) {
        this.standardResolution = standardResolution;
    }
}
