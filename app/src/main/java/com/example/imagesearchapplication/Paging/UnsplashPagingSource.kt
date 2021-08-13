package com.example.imagesearchapplication.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.Networking.UnsplashApi
import com.example.imagesearchapplication.Models.Result
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1


class UnsplashPagingSource(private val unsplashApi: UnsplashApi, private val query: String) :
    PagingSource<Int, Result>() {


    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX


        return try {
            val response = unsplashApi.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if(position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if(photos.isEmpty()) null else position + 1
            )
        }catch (exception : IOException){
            LoadResult.Error(exception)
        }catch (exception : HttpException){
            LoadResult.Error(exception)
        }

    }


}