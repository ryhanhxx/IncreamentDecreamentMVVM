package com.ch.increamendecreamenmvvm.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first

interface CounterDataSource {
    fun getCounterFlow(): Flow<Int>
    suspend fun increament()
    suspend fun decreament()
}

class CounterDataSourceImpl(): CounterDataSource {

    private val counterFlow = MutableStateFlow(0)

    override fun getCounterFlow(): Flow<Int> = counterFlow

    override suspend fun increament() {
    val currentValue = counterFlow.first()
        val value = currentValue + 1
        counterFlow.emit(value)
    }

    override suspend fun decreament() {
        val currentValue = counterFlow.first()
        if (currentValue <= 0) return
        val value = currentValue - 1
        counterFlow.emit(value)
    }

}