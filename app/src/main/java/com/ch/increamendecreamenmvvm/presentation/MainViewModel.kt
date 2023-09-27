package com.ch.increamendecreamenmvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ch.increamendecreamenmvvm.data.CounterDataSource

class MainViewModel: ViewModel() {

    private val _counter: MutableLiveData<Int> = MutableLiveData<Int>().apply {
        postValue(0)
    }
    val counter: LiveData<Int>
        get() = _counter

    fun increment() {
        val currentValue = _counter.value ?: 0
        val value = currentValue + 1
        _counter.postValue(value)
    }

    fun decrement() {
        val currentValue = _counter.value ?: 0
        if (currentValue <= 0) return
        val value = currentValue - 1
        _counter.postValue(value)
    }

}