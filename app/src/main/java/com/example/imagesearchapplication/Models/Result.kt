package com.example.imagesearchapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Result(
    @SerializedName("blur_hash") @Expose val blur_hash: String,
    @SerializedName("color") @Expose val color: String,
    @SerializedName("created_at") @Expose val created_at: String,
    @SerializedName("current_user_collections") @Expose val current_user_collections: List<Any>,
    @SerializedName("description") @Expose val description: String,
    @SerializedName("height") @Expose val height: Int,
    @SerializedName("id") @Expose val id: String,
    @SerializedName("liked_by_user") @Expose val liked_by_user: Boolean,
    @SerializedName("likes") @Expose val likes: Int,
    @SerializedName("links") @Expose val links: Links,
    @SerializedName("urls") @Expose val urls: Urls,
    @SerializedName("user") @Expose val user: User,
    @SerializedName("width") @Expose val width: Int
)