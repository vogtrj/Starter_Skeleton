package com.zekes3dglasses.starterskeleton.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    // Demonstration of LiveData being used with backing field
    private val _sampleIntLiveData = MutableLiveData<Int>(0)
    val sampleIntLiveData: LiveData<Int>
        get() = _sampleIntLiveData

    // The String version of the sampleIntLiveData, used by the fragment xml
    val intInStringFormat = Transformations.map(sampleIntLiveData) {
        it.toString()
    }

    fun addToInt() {
        _sampleIntLiveData.value = _sampleIntLiveData.value?.plus(1) ?: 1
    }
}
