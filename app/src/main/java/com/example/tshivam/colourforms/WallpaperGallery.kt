package com.example.tshivam.colourforms

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tshivam.colourforms.listeners.onFlingDetection
import kotlinx.android.synthetic.main.wallpaper_gallery.*

class WallpaperGallery : AppCompatActivity() {

    private var mInstance: WallpaperGallery? = null



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        getCTX()
        setContentView(R.layout.wallpaper_gallery)
        imagery.setOnTouchListener(object : onFlingDetection(this) {
            public override fun done(){
                Toast.makeText( this@WallpaperGallery,"flung", Toast.LENGTH_SHORT).show()
            }

        })

    }


    public fun getCTX() {
        mInstance = this
    }


}




