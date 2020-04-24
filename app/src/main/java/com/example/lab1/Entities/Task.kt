package com.example.lab1.Entities

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.Month

class Task {
    var id : Int = 0
    @RequiresApi(Build.VERSION_CODES.O)
    var name : String = ""
    constructor(Id: Int, Name :String){
        id = Id
        name = Name
    }
    constructor(Name : String){
        name = Name
    }
}