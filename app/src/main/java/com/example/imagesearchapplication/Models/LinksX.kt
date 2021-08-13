package com.example.imagesearchapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("html") @Expose val html: String,
    @SerializedName("likes") @Expose val likes: String,
    @SerializedName("photos") @Expose val photos: String,
    @SerializedName("self") @Expose val self: String
)