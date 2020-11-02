package com.gloria.GameKids.network;

import com.gloria.GameKids.models.YoutubeGameSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApi {
    @GET("playlistItems")
    Call<YoutubeGameSearchResponse> getPlaylists(
            @Query("part") String part,
            @Query("playlistId") String playlistId,
            @Query("key") String key
    );

}
