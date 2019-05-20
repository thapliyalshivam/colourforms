package com.example.tshivam.colourforms

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var m:LOPA = LOPA()
        m.start()


        fun brexit(){

            m.ex?.post({  for (i in 1..10){
                Log.d("val",i.toString()+"mos")
                SystemClock.sleep(500)
            }

                brexit()
            })


        }

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
