package com.example.imagesearchapplication.Repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.Networking.UnsplashApi
import com.example.imagesearchapplication.Paging.UnsplashPagingSource
import javax.inject.Inject

class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {

    fun getSearchResult(query : String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                UnsplashPagingSource(unsplashApi,query)
            }
        ).liveData

}