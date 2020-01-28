package com.example.thumbnailloader

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object r{
    fun getService() : rn = retrofit.create(rn::class.java)

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com") // 도메인 주소
            .addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
            .build()
}