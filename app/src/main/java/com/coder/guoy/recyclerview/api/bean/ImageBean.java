package com.coder.guoy.recyclerview.api.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/10/9
 * @Descrpiton:美眉
 */
public class ImageBean implements Parcelable {
    private String linkUrl;
    private String imageUrl;
    private String thumbnailImageUrl;
    private String imgaeTitle;

    public ImageBean(String linkUrl, String imageUrl, String imgaeTitle) {
        this.linkUrl = linkUrl;
        this.imageUrl = imageUrl;
        this.imgaeTitle = imgaeTitle;
    }

    protected ImageBean(Parcel in) {
        linkUrl = in.readString();
        imageUrl = in.readString();
        imgaeTitle = in.readString();
        thumbnailImageUrl = in.readString();
    }

    public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
        @Override
        public ImageBean createFromParcel(Parcel in) {
            return new ImageBean(in);
        }

        @Override
        public ImageBean[] newArray(int size) {
            return new ImageBean[size];
        }
    };

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImgaeTitle() {
        return imgaeTitle;
    }

    public void setImgaeTitle(String imgaeTitle) {
        this.imgaeTitle = imgaeTitle;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(linkUrl);
        dest.writeString(imageUrl);
        dest.writeString(imgaeTitle);
        dest.writeString(thumbnailImageUrl);
    }
}
