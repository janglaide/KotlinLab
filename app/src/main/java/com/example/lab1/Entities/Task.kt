package com.example.lab1.Entities

import android.content.res.Resources
import com.example.lab1.DBOpenHelperTask
import com.example.lab1.MainActivity


class Task{

    var difficulty: String
    var type: String
    var description: String
    var descriptionId: Int

    constructor(){
        difficulty = ""
        type = ""
        description = ""
        descriptionId = 0
    }

    constructor(d: String, t: String, r: Resources, context: MainActivity){
        difficulty = d
        type = t
        descriptionId = getDescriptionId(r)
        description = getDescription(descriptionId, context)
    }

    private fun getDescriptionId(resources : Resources) : Int{
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
            diffRate
        }else{
            diffRate + 3
        }
        return key
    }
    private fun getDescription(id : Int, context: MainActivity) : String{
        val db = DBOpenHelperTask(context, null)
        return db.getTask(id)
    }
}