package com.kampusmerdeka.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var angka = 0

    fun tambahAngka() {
        angka++
    }

    fun kurangAngka() {
        angka--
    }

    fun clearAngka() {
        angka=0
    }
}