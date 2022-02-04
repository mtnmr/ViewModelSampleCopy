package com.example.viewmodelsamplecopy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.example.viewmodelsamplecopy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val viewModel: CountViewModel by viewModels()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.countModel = viewModel
        binding.lifecycleOwner = this


        var counterA: Int = 0

//        val viewModel: CountViewModel= ViewModelProvider(this).get(CountViewModel::class.java)
//        val viewModel: CountViewModel by viewModels()

        val text1 = findViewById<TextView>(R.id.text1)
//        val text2 = findViewById<TextView>(R.id.text2)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            counterA++
            text1.text = counterA.toString()

            viewModel.countUp()
//            viewModel.counterB.value = viewModel.counterB.value!! + 1
        }

//        val countObserver = Observer<Int>{counter ->
//            text2.text = counter.toString()
//        }
//        viewModel.counterB.observe(this, countObserver)
////    }
    }
}