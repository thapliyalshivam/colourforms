package com.example.tshivam.colourforms.listeners

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.tshivam.colourforms.WallpaperGallery


public abstract class onFlingDetection  : View.OnTouchListener {


     var gd : GestureDetector

    constructor(ctx: Context){
        gd = GestureDetector(Flingdetect(ctx))
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
         gd.onTouchEvent(event)
        return true
    }

    public open fun done(){

    }



    private inner class Flingdetect(val ctx: Context) : GestureDetector.SimpleOnGestureListener(){

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            done()
            return true
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            done()
            Toast.makeText( ctx,"fling", Toast.LENGTH_SHORT).show()
            return super.onScroll(e1, e2, distanceX, distanceY)
        }
    }
}



