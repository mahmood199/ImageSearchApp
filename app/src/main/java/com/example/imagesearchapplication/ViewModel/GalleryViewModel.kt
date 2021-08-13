package com.example.imagesearchapplication.ViewModel

import androidx.lifecycle.ViewModel
import com.example.imagesearchapplication.Repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: UnsplashRepository) :
    ViewModel() {
}