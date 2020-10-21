//package com.gloria.GameKids;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import com.daimajia.slider.library.SliderLayout;
//
//import retrofit2.Retrofit;
//
//public class BabyVideos extends AppCompatActivity {
//    private SliderLayout sliderLayout;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_baby_videos);
//        sliderLayout = findViewById(R.id.sliderLayout);
//        getPlaylists();
//    }
//    private void getPlaylists(){
//        GetDataService.dataservice = RetrofitInstance.getRetrofit().create(getDataService.class)
//
//    }
//}