package com.example.tshivam.colourforms

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tshivam.colourforms.Adapter.ParallaxAdapter
import com.example.tshivam.colourforms.service.SummerWallpaperService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val adp = ParallaxAdapter(this)
        RV.adapter = adp

        stall.setOnClickListener {

      //  brexit()
//
            Log.d("val","doinnnn")
           var intent: Intent = Intent(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER)
            intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, ComponentName(this, SummerWallpaperService().javaClass))
            startActivityForResult(intent,0)


        }

    }
}
