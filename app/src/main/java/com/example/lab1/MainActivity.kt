package com.example.lab1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_chooser.*
import kotlinx.android.synthetic.main.fragment_info.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(ChooserFragment())
    }

    fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.myFragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun onHistoryClicked(view: View){

        val db = DBOpenHelperHistory(this, null)
        val cursor = db.getAllHistory()
        cursor!!.moveToFirst()
        if(cursor.count == 0){
            Toast.makeText(
                this, "Empty history",
                Toast.LENGTH_SHORT
            ).show()
        }
        else{
            onPause()
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
