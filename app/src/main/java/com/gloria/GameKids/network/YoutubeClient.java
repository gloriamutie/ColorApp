package com.gloria.GameKids.network;

import com.gloria.GameKids.network.YoutubeApi;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.gloria.GameKids.Constants.YOUTUBE_API_KEY;
import static com.gloria.GameKids.Constants.YOUTUBE_BASE_URL;

public class YoutubeClient {

    private static Retrofit retrofit = null;

    public static YoutubeApi getClient() {

        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                 .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(YOUTUBE_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

            return retrofit.create(YoutubeApi.class);

        }

    }

