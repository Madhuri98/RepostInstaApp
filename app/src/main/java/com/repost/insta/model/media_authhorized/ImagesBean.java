package com.repost.insta.model.media_authhorized;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niyati on 2/10/2017.
 */
public class ImagesBean {
    /**
     * thumbnail : {"width":150,"height":150,"url":"https://scontent-lhr3-1.cdninstagram.com/t51.2885-15/s150x150/e15/15538113_570711839797773_8072083036432236544_n.jpg"}
     * low_resolution : {"width":320,"height":320,"url":"https://scontent-lhr3-1.cdninstagram.com/t51.2885-15/s320x320/e15/15538113_570711839797773_8072083036432236544_n.jpg"}
     * standard_resolution : {"width":640,"height":640,"url":"https://scontent-lhr3-1.cdninstagram.com/t51.2885-15/s640x640/e15/15538113_570711839797773_8072083036432236544_n.jpg"}
     */

    @SerializedName("thumbnail")
    private ThumbnailBean thumbnail;
    @SerializedName("low_resolution")
    private LowResolutionBeanX lowResolution;
    @SerializedName("standard_resolution")
    private StandardResolutionBeanX standardResolution;

    public ThumbnailBean getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailBean thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LowResolutionBeanX getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(LowResolutionBeanX lowResolution) {
        this.lowResolution = lowResolution;
    }

    public StandardResolutionBeanX getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(StandardResolutionBeanX standardResolution) {
        this.standardResolution = standardResolution;
    }
}
