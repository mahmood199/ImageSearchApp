package com.example.imagesearchapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("full") @Expose val full: String,
    @SerializedName("raw") @Expose val raw: String,
    @SerializedName("regular") @Expose val regular: String,
    @SerializedName("small") @Expose val small: String,
    @SerializedName("thumb") @Expose val thumb: String
)