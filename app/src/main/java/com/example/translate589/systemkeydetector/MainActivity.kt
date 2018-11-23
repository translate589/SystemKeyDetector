package com.example.translate589.systemkeydetector

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : Activity() {

    private var mSystemKeyEventReceiver:SystemKeyEventReceiver? = null
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registSystemKeyListener()
    }

    fun registSystemKeyListener() {
        mSystemKeyEventReceiver = SystemKeyEventReceiver(object : SystemKeyEventReceiver.SystemKeyEventReceiverListener {
            override fun onPressHomeKey() {
                Log.i(TAG,"onPressHomeKey")
                showToast("onPressHomeKey")
            }

            override fun onLongPressHomeKey() {
                Log.i(TAG,"onLongPressHomeKey")
                showToast("onLongPressHomeKey")
            }

            override fun onScreenLock() {
                Log.i(TAG,"onScreenLock")
                showToast("onScreenLock")
            }

            override fun onPressAssist() {
                Log.i(TAG,"onPressAssist")
                showToast("onPressAssist")
            }
        })

        IntentFilter().apply {
            addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
            registerReceiver(mSystemKeyEventReceiver,this)
        }
    }

    fun showToast(msg:String) {
        Toast.makeText(this@MainActivity,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mSystemKeyEventReceiver?.let{
            unregisterReceiver(it)
        }
        mSystemKeyEventReceiver = null
    }
}
