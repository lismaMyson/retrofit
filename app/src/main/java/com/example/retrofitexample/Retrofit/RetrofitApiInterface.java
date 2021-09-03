package com.example.retrofitexample.Retrofit;

import com.example.retrofitexample.Model.RetrofitListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {
    String BASE_URL="https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<RetrofitListModel>> getSuperHero();
}
