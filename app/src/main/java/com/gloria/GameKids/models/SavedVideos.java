package com.gloria.GameKids.models;

public class SavedVideos {

    private String userId;
    private String videoId;

    public SavedVideos() {
    }

    public SavedVideos(String userId, String videoId) {
        this.userId = userId;
        this.videoId = videoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
