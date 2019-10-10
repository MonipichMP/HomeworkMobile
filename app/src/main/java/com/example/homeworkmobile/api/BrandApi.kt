package com.example.homeworkmobile.api

import com.example.homeworkmobile.model.Brand
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BrandApi{

    companion object{
        const val BASE_URL = "http://lp.js-cambodia.com/rupp/"

        operator fun invoke() : BrandApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BrandApi::class.java)
        }
    }

    @GET("brands.php")
    fun getBrands() : Call<List<Brand>>

}