package com.example.Networking

import androidx.databinding.library.baseAdapters.BuildConfig
import com.example.imagesearchapplication.Models.Root
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = "eI_nkhUkIgulkhYmbh57MxLIpHtDvB90pcf0aftEM5Q"
    }


    @Headers("Accept-Version: v1" , "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(@Query("query") query: String, @Query("page") page: Int, @Query("per_page") per_page: Int, ) : Root




}