package com.example.imagesearchapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("first_name") @Expose val first_name: String,
    @SerializedName("id") @Expose val id: String,
    @SerializedName("instagram_username") @Expose val instagram_username: String,
    @SerializedName("last_name") @Expose val last_name: String,
    @SerializedName("links") @Expose val links: LinksX,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("portfolio_url") @Expose val portfolio_url: String,
    @SerializedName("profile_image") @Expose val profile_image: ProfileImage,
    @SerializedName("twitter_username") @Expose val twitter_username: String,
    @SerializedName("username") @Expose val username: String
)