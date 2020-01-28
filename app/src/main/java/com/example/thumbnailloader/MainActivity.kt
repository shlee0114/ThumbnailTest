package com.example.thumbnailloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://img.youtube.com/vi/JNL44p5kzTk/maxresdefault.jpg"

        val image = findViewById<ImageView>(R.id.testImage)
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
        val displayThumbnailWidth = displayMetrics.widthPixels
        val displayThumbnailHeight = (displayMetrics.widthPixels /16 * 9)

        Glide.with(this).load(url).override(displayThumbnailWidth, displayThumbnailHeight).into(image)

    }
}
