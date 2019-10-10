package com.example.homeworkmobile.api

import com.example.homeworkmobile.model.Phone
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface PhoneApi{

    companion object{
        operator fun invoke() : PhoneApi{
            return Retrofit.Builder()
                .baseUrl(BrandApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhoneApi::class.java)
        }
    }

    @GET("phones.php")
    fun getPhones() : Call<List<Phone>>

}