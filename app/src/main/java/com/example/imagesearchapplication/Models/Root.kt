package com.example.imagesearchapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Root(
    @SerializedName("results") @Expose val results: List<Result>,
    @SerializedName("total") @Expose val total: Int,
    @SerializedName("total_pages") @Expose val total_pages: Int
)