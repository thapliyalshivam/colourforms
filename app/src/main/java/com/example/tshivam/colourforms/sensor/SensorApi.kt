package com.example.tshivam.colourforms.sensor

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

import android.util.Log

class SensorApi : SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var con: Context
    private var mLight: Sensor? = null
    var lux: Float = 0.0f


    constructor( con : Context){
        this.con = con
        sensorManager = con.getSystemService(SENSOR_SERVICE) as SensorManager
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensorManager.registerListener(this,mLight,
                SensorManager.SENSOR_DELAY_GAME)

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Do something here if sensor accuracy changes.
    }


    public fun deregister(){
        sensorManager.unregisterListener(this)
    }

    public  fun reregister(){
        sensorManager.registerListener(this,mLight,
                SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onSensorChanged(event: SensorEvent) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        lux = event.values[0]


        val alpha: Float = 0.8f


        Log.d("vals", event.values[0].toString())

        // Isolate the force of gravity with the low-pass filter.
//        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0]
//        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1]
//        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2]
//
//        // Remove the gravity contribution with the high-pass filter.
//        linear_acceleration[0] = event.values[0] - gravity[0]
//        linear_acceleration[1] = event.values[1] - gravity[1]
//        linear_acceleration[2] = event.values[2] - gravity[2]
        // Do something with this sensor value.
    }
}