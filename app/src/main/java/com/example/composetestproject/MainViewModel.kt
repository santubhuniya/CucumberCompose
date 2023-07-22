package com.example.composetestproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Santu Kumar Bhuniya on 21/07/23.
 */
@HiltViewModel
class MainViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    fun sayHello(){
        System.out.println("Test")
    }
}