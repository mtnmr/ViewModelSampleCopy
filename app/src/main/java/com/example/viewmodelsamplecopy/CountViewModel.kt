package com.example.viewmodelsamplecopy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    val counterB : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        counterB.value = 0
    }
}