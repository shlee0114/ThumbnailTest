package com.example.thumbnailloader

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface rn{
    @GET("youtube/v3/search")
    fun request(
        @Query("id") id : String,
        @Query("key") key : String,
        @Query("part") part : String
    ) : Call<model>
}