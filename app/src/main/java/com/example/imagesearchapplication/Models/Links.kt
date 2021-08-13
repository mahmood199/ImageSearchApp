package com.example.imagesearchapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("download") @Expose val  download: String,
    @SerializedName("html") @Expose val  html: String,
    @SerializedName("self") @Expose val  self: String
)