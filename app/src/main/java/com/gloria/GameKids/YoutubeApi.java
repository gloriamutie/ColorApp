package com.gloria.GameKids;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApi {
    @GET("playlists")
    Call<com.gloria.GameKids.YoutubeGameSearchResponse> getPlaylists(
            @Query("part") String part,
            @Query("key") String key,
            @Query("channelId") String channelId

    );

}
