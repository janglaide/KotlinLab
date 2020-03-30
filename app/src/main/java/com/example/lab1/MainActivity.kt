package com.example.lab1

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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

        val flag: Boolean = (radioDiff.checkedRadioButtonId != -1) and (radioType.checkedRadioButtonId != -1)

        if (flag) {
            val task = Task(findViewById<RadioButton>(radioDiff.checkedRadioButtonId).text as String,
                findViewById<RadioButton>(radioType.checkedRadioButtonId).text as String,
                resources)

            taskTxt.text = task.getDescription()

        } else {
            Toast.makeText(
                applicationContext, "Not all or none selected",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
