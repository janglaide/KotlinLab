package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.lab1.Entities.Task
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_history)

        /*historyView.text = ""
        val db = DBOpenHelperTask(this, null)
        val cursor = db.getAllTasks()
        cursor!!.moveToFirst()

        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_ID))))
        historyView.append("\t\t")
        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_NAME))))
        while (cursor.moveToNext()) {
            historyView.append("\n\n")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_ID))))
            historyView.append("\t\t")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_NAME))))
        }
        cursor.close()*/
        getHistory()
    }
    private fun getHistory(){
        historyView.text = ""
        val db = DBOpenHelperHistory(this, null)
        val cursor = db.getAllHistory()
        cursor!!.moveToFirst()

        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_ID))))
        historyView.append("\t\t")
        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_DATETIME))))
        historyView.append("\t\t")
        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_TASKID))))
        while (cursor.moveToNext()) {
            historyView.append("\n\n")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_ID))))
            historyView.append("\t\t")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_DATETIME))))
            historyView.append("\t\t")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_TASKID))))
        }
        cursor.close()

    }

    fun onBackClicked(view: View){
        setResult(Activity.RESULT_OK)
        finish()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
