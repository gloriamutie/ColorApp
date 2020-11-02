
package com.gloria.GameKids.models;

import org.parceler.Parcel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Parcel
public class ResourceId {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("videoId")
    @Expose
    private String videoId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourceId() {
    }

    /**
     * 
     * @param kind
     * @param videoId
     */
    public ResourceId(String kind, String videoId) {
        super();
        this.kind = kind;
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

}
