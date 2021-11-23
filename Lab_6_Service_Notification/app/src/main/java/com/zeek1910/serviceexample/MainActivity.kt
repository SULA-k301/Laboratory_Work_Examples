package com.zeek1910.serviceexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val broadCastReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.let {
                    val data = it.getIntExtra(DownloadService.KEY_DATA,0)
                    Log.d("Zeek","Received -> $data")
                }
            }
        }
        registerReceiver(broadCastReceiver, IntentFilter(ACTION))
    }

    override fun onStart() {
        super.onStart()
        val urlString = "https://example.com/file.pdf"
        startService(Intent(this, DownloadService::class.java).apply {
            putExtra(
                KEY_URL,
                urlString
            )
        })
    }

    companion object {
        const val ACTION = "action"
        const val KEY_URL = "KEY_URL"
    }
}