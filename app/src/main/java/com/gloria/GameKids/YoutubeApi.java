package com.gloria.GameKids;

import com.gloria.GameKids.models.Playlistnew;
import com.gloria.GameKids.models.YoutubeGameSearchResponse;
import com.google.api.services.youtube.model.VideoContentDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApi {
    @GET("playlists")
    Call<YoutubeGameSearchResponse> getPlaylists(
            @Query("part") String part,
            @Query("key") String key,
            @Query("playlistId") String playlistId

    );

}
