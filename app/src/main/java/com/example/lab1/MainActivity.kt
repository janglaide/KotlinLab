package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resButton.setOnClickListener {
            val diffId: Int = radioDiff.checkedRadioButtonId
            val typeIdrad: Int = radioType.checkedRadioButtonId

            val flag: Boolean = (diffId != -1) and (typeIdrad != -1)

            if (flag) {
                val difficulty: RadioButton = findViewById(radioDiff.checkedRadioButtonId)
                val taskType: RadioButton = findViewById(radioType.checkedRadioButtonId)

                taskTxt.text = "qwerty"

                val diffKey: String = difficulty.text as String
                val typeKey: String = taskType.text as String

                val diffRate = when(diffKey){
                    "easy" -> 1
                    "medium" -> 2
                    "hard" -> 3
                    else -> 0
                }

                val typeRate = when(typeKey){
                    "theory" -> 1
                    "practice" -> 2
                    else -> 0
                }

                val texts: List<String> = listOf("Difficulty: Easy\nType: Theory\nDescribe all present tenses using examples",
                    "Difficulty: Medium\nType: Theory\nDescribe all past tenses using examples",
                    "Difficulty: Hard\nType: Theory\nDescribe all future tenses using examples",
                    "Difficulty: Easy\nType: Practice\nWrite a letter to your pen-friend describing your usual day at school, university or work",
                    "Difficulty: Medium\nType: Practice\nWrite a formal essay about an interesting and well-known historical event",
                    "Difficulty: Hard\nType: Practice\nWrite an opinion essay about new technologies and describe how will our world be look like in 20 years")

                val key = if(typeRate == 1){
                    diffRate - typeRate
                }else{
                    diffRate + typeRate
                }

                taskTxt.text = texts[key]

            } else {
                Toast.makeText(
                    applicationContext, "Not all or none selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
