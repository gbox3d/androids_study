package com.example.ex02timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimerViewModel: ViewModel() {
    private val _time = MutableStateFlow(0)
    val time: StateFlow<Int> get() = _time

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> get() = _isRunning

    private fun _startTimer() {

        viewModelScope.launch {
            while (_isRunning.value) {
                delay(1000)
                _time.value++
            }
        }
    }

    fun toggle() {
        if(isRunning.value) {
            _isRunning.value = false
        } else {
            _isRunning.value = true
            _startTimer()

        }
    }

    fun reset() {
        _time.value = 0
    }
}