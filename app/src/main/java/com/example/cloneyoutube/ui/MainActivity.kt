package com.example.cloneyoutube.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.cloneyoutube.R
import com.example.cloneyoutube.viewmodel.InitialViewModel
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModels:InitialViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModels.showError.observe(this, Observer {
            Log.e("showError",it)
        })
        viewModels.covidResponse.observe(this, Observer {
            Log.e("covidResponse",Gson().toJson(it).toString())
//            updateUI
        })
        viewModels.showLoading.observe(this, Observer {
            Log.e("Loading",it.toString())
        })
        viewModels.getCovidData()
    }
}