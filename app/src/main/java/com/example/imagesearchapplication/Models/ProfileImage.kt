package com.example.imagesearchapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfileImage(
    @SerializedName("large") @Expose val large: String,
    @SerializedName("medium") @Expose val medium: String,
    @SerializedName("small") @Expose val small: String
)