package com.example.tshivam.colourforms

import android.os.*
import android.util.Log
import java.util.concurrent.ExecutorService
import java.util.logging.Handler

class LOPA : Thread() {

     var ex: android.os.Handler?=null

    override fun run() {
        Looper.prepare()
        ex = android.os.Handler()
        Looper.loop()


        Log.d("val","ENDEr")


    }
}


