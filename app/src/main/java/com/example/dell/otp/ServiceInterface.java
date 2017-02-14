package com.example.dell.otp;



import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by hp on 20-02-2016.
 */
public interface ServiceInterface {

    @GET("/questions/unanswered")
    void getUnansweresandroidquestions(@Query("api_key") String api_key, @Query("site") String site, @Query("tagged") String tagged, @Query("order") String order, @Query("sort") String sort, Callback<Questions> responseCallback);



}
