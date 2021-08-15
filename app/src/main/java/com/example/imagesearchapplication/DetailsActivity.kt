package com.example.imagesearchapplication

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.TransitionOptions
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.imagesearchapplication.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_details)
        binding.lifecycleOwner = this

        val image = intent.getStringExtra("PHOTO_LINK").toString()
        val creatorName = intent.getStringExtra("CREATOR_NAME").toString()

        binding.apply {
            Glide.with(this@DetailsActivity)
                .load(image)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .error(R.drawable.error)
                .listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        progressBar3.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        progressBar3.visibility = View.GONE
                        textViewDescription.text = "Photo by ${creatorName}"
                        return false
                    }
                })
                .into(imageView)

            textViewDescription.visibility = View.VISIBLE


            imageView.setOnClickListener{
                val uri = Uri.parse(image)
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(intent)
            }


            textViewDescription.paint.isUnderlineText = true

        }

    }
}