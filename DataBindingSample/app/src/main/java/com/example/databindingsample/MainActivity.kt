package com.example.databindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels

class MainActivity : AppCompatActivity() {

//    private val viewModel: CountModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: CountModel by viewModels()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, CountFragment())
            .commit()
    }


}