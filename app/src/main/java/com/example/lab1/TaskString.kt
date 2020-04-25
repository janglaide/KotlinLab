package com.example.lab1

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity


class TaskString{

    var difficulty: String
    var type: String
    var description: String

    constructor(){
        difficulty = ""
        type = ""
        description = ""
    }

    constructor(d: String, t: String, r: Resources){
        difficulty = d
        type = t
        description = getDescription(r)
    }
    private fun getDescription(resources : Resources) : String{
        val taskArray = resources.getStringArray(R.array.tasks)
        val diffRate = when(difficulty){
            "easy" -> 1
            "medium" -> 2
            "hard" -> 3
            else -> 0
        }

        val typeRate = when(type){
            "theory" -> 1
            "practice" -> 2
            else -> 0
        }

        val key = if(typeRate == 1){
            diffRate - typeRate
        }else{
            diffRate + typeRate
        }

        return taskArray[key]
    }
}