package com.zeek1910.lab_4_concurrency

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(){

    private lateinit var buttonStart: Button
    private lateinit var buttonStop: Button
    private lateinit var buttonStartWithCoroutine: Button
    private lateinit var tvProgress: TextView
    private lateinit var tvProgress2: TextView

    private var isDownload = true
    private var isDownloadWithCoroutine = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart = findViewById(R.id.buttonStart)
        buttonStart.setOnClickListener {
            Thread { download() }.start()
        }
        buttonStartWithCoroutine = findViewById(R.id.buttonStartCoroutine)
        buttonStartWithCoroutine.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                downloadWithCoroutine()
            }
        }
        buttonStop = findViewById(R.id.buttonStop)
        buttonStop.setOnClickListener {
            isDownload = false
        }
        tvProgress = findViewById(R.id.textViewProgress)
        tvProgress2 = findViewById(R.id.textViewProgress2)

    }


    private fun download() {
        var progress = 0
        while (isDownload) {
            TimeUnit.SECONDS.sleep(1)
            progress++
            runOnUiThread {
                tvProgress.text = progress.toString()
            }
        }
        runOnUiThread {
            tvProgress.text = "Download finished!"
        }

    }

    private suspend fun downloadWithCoroutine(){
        var progress = 0
        while (isDownloadWithCoroutine) {
            delay(1000)
            progress++

            withContext(Dispatchers.Main){
                tvProgress2.text = progress.toString()
            }
        }
        runOnUiThread {
            tvProgress2.text = "Download finished!"
        }
    }
}