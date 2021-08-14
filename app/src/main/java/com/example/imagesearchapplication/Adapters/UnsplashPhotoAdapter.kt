package com.example.imagesearchapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.imagesearchapplication.Models.Result
import com.example.imagesearchapplication.R
import com.example.imagesearchapplication.databinding.ItemUnsplashPhotoBinding


class UnsplashPhotoAdapter :
    PagingDataAdapter<Result, UnsplashPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }

    }

    class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(result: Result) {
            binding.apply {
                textView.setText(result.user.first_name)

                Glide.with(itemView)
                    .load(result.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade(500))
                    .error(R.drawable.error)
                    .into(imageview)

            }
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<Result>() {

            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem == newItem
        }
    }


}