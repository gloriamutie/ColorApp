package com.gloria.GameKids;

import com.gloria.GameKids.models.YoutubeGameSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApi {
    @GET("playlists")
    Call<YoutubeGameSearchResponse> getPlaylists(
            @Query("part") String part,
            @Query("key") String key,
            @Query("channelId") String channelId,
             @Query("pageToken") String pageToken
    );

}
