package com.example.eventbusdemo

import android.os.Handler
import android.util.Log
import org.greenrobot.eventbus.EventBus


/**
 * Created by Mehedi Hasan on 3/4/2020.
 */
class PublisherClass {

    private val handler = Handler()
    private var runnable: Runnable? = null

    var x = 0
    fun publishEvent() {

        runnable = Runnable {
            x++
            Log.d("EventPrintPublisher", x.toString())
            EventBus.getDefault().post(EventClass(x))

            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)

    }


}