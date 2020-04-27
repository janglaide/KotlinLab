package com.example.lab1.Entities

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.Month

class History @RequiresApi(Build.VERSION_CODES.O) constructor(TaskId: Int) {
    var id : Int = 0
    @RequiresApi(Build.VERSION_CODES.O)
    var datetime : LocalDateTime = LocalDateTime.of(2020, Month.APRIL, 15, 3, 15)
    var taskId: Int = TaskId

    init {
        datetime = LocalDateTime.now()
    }
}