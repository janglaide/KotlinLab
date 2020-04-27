package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_history)

        val actionBar = supportActionBar
        actionBar!!.title = "Used tasks history"

        getHistory()
    }
    private fun getHistory(){
        historyView.text = ""
        val db = DBOpenHelperHistory(this, null)
        val cursor = db.getAllHistory()
        cursor!!.moveToFirst()

        historyView.append(cursor.getColumnName(0))
        historyView.append("\t\t")
        historyView.append(cursor.getColumnName(1))
        historyView.append("                            ")
        historyView.append(cursor.getColumnName(2))

        historyView.append("\n\n")

        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_ID))))
        historyView.append("\t\t\t")
        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_DATETIME))))
        historyView.append("      ")
        historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_TASKID))))
        while (cursor.moveToNext()) {
            historyView.append("\n\n")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_ID))))
            historyView.append("\t\t\t")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_DATETIME))))
            historyView.append("      ")
            historyView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperHistory.COLUMN_NAME_TASKID))))
        }
        cursor.close()

    }

    fun onShowTasksClicked(view: View){
        onPause()

        val intent = Intent(this, TasksActivity::class.java)
        startActivity(intent)
    }

    fun onClearHistoryClicked(view: View){
        setResult(Activity.RESULT_OK)
        finish()

        val db = DBOpenHelperHistory(this, null)
        db.deleteAll()
    }
}
