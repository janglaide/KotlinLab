package com.example.lab1.Entities

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

    constructor(d: String, t: String, context: MainActivity){
        difficulty = d
        type = t
        descriptionId = findDescriptionId()
        description = getDescription(descriptionId, context)
    }

    private fun findDescriptionId(): Int{
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

        return if(typeRate == 1){
            diffRate
        }else{
            diffRate + 3
        }
    }
    private fun getDescription(id : Int, context: MainActivity) : String{
        val db = DBOpenHelperTask(context, null)
        return db.getTask(id)
    }
}