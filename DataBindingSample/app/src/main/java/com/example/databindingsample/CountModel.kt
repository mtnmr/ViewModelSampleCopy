package com.example.databindingsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CountModel:ViewModel() {
    private val _modelCount : MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        _modelCount.value = 0
    }

    val modelCount:LiveData<Int> = _modelCount

    fun countUp(){
        _modelCount.value = _modelCount.value?.plus(1)
    }
}