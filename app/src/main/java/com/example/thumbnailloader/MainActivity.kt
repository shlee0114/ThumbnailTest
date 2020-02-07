package com.example.thumbnailloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        r.getService().request("JNL44p5kzTk", "AIzaSyBpw3iXexye1qdYs7gmp1-et-H1f4-V5Vc","snippet").enqueue(object : Callback<model> {
            override fun onFailure(call: Call<model>, t: Throwable) {
                Log.i("tt","tt")
            }

            override fun onResponse(call: Call<model>, response: Response<model>) {
                if (response.isSuccessful) {
                    val image = response.body()
                }
            }

        })

        val url = "https://img.youtube.com/vi/JNL44p5kzTk/hqdefault.jpg"

        val image = findViewById<YouTubeThumbnailView>(R.id.testImage)

        image.initialize("AIzaSyBpw3iXexye1qdYs7gmp1-et-H1f4-V5Vc", object : YouTubeThumbnailView.OnInitializedListener{



            override fun onInitializationFailure(
                p0: YouTubeThumbnailView?,
                p1: YouTubeInitializationResult?
            ) {

            }

            override fun onInitializationSuccess(
                p0: YouTubeThumbnailView?,
                p1: YouTubeThumbnailLoader?
            ) {
                p1!!.setVideo("JNL44p5kzTk")
                p1!!.setOnThumbnailLoadedListener(object : YouTubeThumbnailLoader.OnThumbnailLoadedListener{
                    override fun onThumbnailError(
                        p0: YouTubeThumbnailView?,
                        p1: YouTubeThumbnailLoader.ErrorReason?
                    ) {

                    }

                    override fun onThumbnailLoaded(p0: YouTubeThumbnailView?, Sp1: String?) {
                        p1!!.release()
                    }
                })
            }
        })
       Glide.with(this).load(url).into(image)

    }
}
