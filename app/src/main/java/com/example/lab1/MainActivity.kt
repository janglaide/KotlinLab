package com.example.lab1

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_chooser.*
import kotlinx.android.synthetic.main.fragment_info.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buttonClicked(view: View){
        val diffId: Int = radioDiff.checkedRadioButtonId
        val typeIdrad: Int = radioType.checkedRadioButtonId

        val flag: Boolean = (diffId != -1) and (typeIdrad != -1)

        if (flag) {
            val difficulty: RadioButton = findViewById(radioDiff.checkedRadioButtonId)
            val taskType: RadioButton = findViewById(radioType.checkedRadioButtonId)

            val diffKey: String = difficulty.text as String
            val typeKey: String = taskType.text as String

            val taskArray = resources.getStringArray(R.array.tasks)

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

            val key = if(typeRate == 1){
                diffRate - typeRate
            }else{
                diffRate + typeRate
            }

            taskTxt.text = taskArray[key]

        } else {
            Toast.makeText(
                applicationContext, "Not all or none selected",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
