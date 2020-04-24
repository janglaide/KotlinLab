package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }

    fun onBackClicked(view: View){
        setResult(Activity.RESULT_OK)
        finish()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
