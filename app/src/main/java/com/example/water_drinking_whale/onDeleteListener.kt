package com.example.water_drinking_whale

import com.example.water_drinking_whale.database.Notice

interface onDeleteListener {
    fun onDeleteListener(notice: Notice)
}