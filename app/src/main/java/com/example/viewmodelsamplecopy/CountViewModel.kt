package com.example.viewmodelsamplecopy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    private val _counterB:MutableLiveData<Int> = MutableLiveData<Int>(0)

    val counterB:LiveData<Int> = _counterB

//    val counterB : MutableLiveData<Int> by lazy {
//        MutableLiveData<Int>()
//    }
//
//    init {
//        counterB.value = 0
//    }

    fun countUp(){
        _counterB.value = _counterB.value!! + 1
    }
}