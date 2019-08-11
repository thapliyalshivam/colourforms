package com.example.tshivam.colourforms

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.service.wallpaper.WallpaperService
import android.service.wallpaper.WallpaperService.Engine
import android.util.Log
import android.view.SurfaceHolder
import java.io.FileDescriptor
import java.io.PrintWriter

class SummerWallpaperService : WallpaperService(){
    override fun onCreateEngine(): WallpaperService.Engine {

        return SummerEngine()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    private inner class SummerEngine : WallpaperService.Engine(){
        internal var Holder: SurfaceHolder? = null
        private var visible: Boolean = false
        private val th:Runnable
        private val handler: Handler
        var paint:Paint = Paint()



        init {
            paint.setColor(Color.parseColor("#FFFFFF"))
            paint.setStrokeWidth(30F)
            paint.setStyle(Paint.Style.STROKE)
            paint.setAntiAlias(true)
            paint.setDither(true)
            handler = Handler(Looper.myLooper())
            this.th = Runnable {

                Log.d("val","initiated frame")
                draw()
            }
        }

        private fun draw() {


            val holder = surfaceHolder
            var canvas: Canvas? = null

            try {
                // redrawEverything means that the whole screen is dirty, reset all params and redraw everything

                    canvas = holder.lockCanvas()

                if (canvas != null) {
                    drawimg(canvas)
                }
            } finally {
                if (canvas != null) {
                    try {
                        holder.unlockCanvasAndPost(canvas)
                    } catch (ignore: Exception) {
                    }

                }
            }
                drawFrame()
        }


        override fun onVisibilityChanged(visible: Boolean) {
            this.visible = visible
            Log.d("val","visibility has changed")
            if (visible) {
                drawFrame()
            }
        }


        private fun drawimg(canvas: Canvas){
            canvas.drawLine(0f,0f,300f,300f,paint)
            canvas.drawCircle(10.0f,10.0f,40.0f,paint)

        }
        private fun drawFrame() {
            if(this.visible) {
                handler.post(this.th)
            }
        }

        override fun onCreate(surfaceHolder: SurfaceHolder?) {
            Holder = surfaceHolder

            super.onCreate(surfaceHolder)

        }

        override fun onSurfaceCreated(holder: SurfaceHolder?) {
            super.onSurfaceCreated(holder)
        }

        override fun onSurfaceDestroyed(holder: SurfaceHolder?) {
            super.onSurfaceDestroyed(holder)
        }
        override fun onSurfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
            super.onSurfaceChanged(holder, format, width, height)
        }
    }

}
