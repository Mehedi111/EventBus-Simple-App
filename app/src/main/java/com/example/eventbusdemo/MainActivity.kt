package com.example.eventbusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_one.setOnClickListener {
            val publisherClass = PublisherClass()
            publisherClass.publishEvent()
        }

        button_Two.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }


    @Subscribe()
    public fun onEvent(message: EventClass) {
        Log.d("EventPrintMain", message.v.toString())
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}
