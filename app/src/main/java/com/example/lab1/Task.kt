package com.example.lab1

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity


class Task(diff: String, t: String, r: Resources) {

    private var difficulty: String = diff
    private var type: String = t
    private var resources: Resources = r

    fun getDescription() : String{
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