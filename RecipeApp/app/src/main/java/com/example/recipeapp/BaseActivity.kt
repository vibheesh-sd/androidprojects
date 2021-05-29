package com.example.recipeapp

import android.app.Service
import android.app.job.JobInfo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import kotlinx.coroutines.*
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


open class BaseActivity : AppCompatActivity(),CoroutineScope {
    private lateinit var job: Job
    override val coroutineContext:CoroutineContext
    get() = job +Dispatchers.main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = job()

    }

    overide fun onDestroy(){
        super.onDestroy()
        job.cancel()
    }

    
}