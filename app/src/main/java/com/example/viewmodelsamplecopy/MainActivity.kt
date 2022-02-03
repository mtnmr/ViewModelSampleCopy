package com.example.viewmodelsamplecopy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counterA : Int = 0

        val viewModel: CountViewModel= ViewModelProvider(this).get(CountViewModel::class.java)


        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            counterA ++
            text1.text = counterA.toString()

            viewModel.counterB.value = viewModel.counterB.value!! + 1
            text2.text = viewModel.counterB.toString()

            val countObserver = Observer<Int>{counter ->
                text2.text = counter.toString()
            }
            viewModel.counterB.observe(this, countObserver)
        }
    }
}