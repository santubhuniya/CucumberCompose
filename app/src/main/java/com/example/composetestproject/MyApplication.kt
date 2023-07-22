package com.example.composetestproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Santu Kumar Bhuniya on 21/07/23.
 */
@HiltAndroidApp
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}