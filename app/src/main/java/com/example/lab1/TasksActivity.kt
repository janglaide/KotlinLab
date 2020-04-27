package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_tasks.*

class TasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        val actionBar = supportActionBar
        actionBar!!.title = "List of tasks"

        getTasks()
    }
    private fun getTasks(){
        tasksView.text = ""
        val db = DBOpenHelperTask(this, null)
        val cursor = db.getAllTasks()
        cursor!!.moveToFirst()

        tasksView.append(cursor.getColumnName(0))
        tasksView.append("\t\t")
        tasksView.append(cursor.getColumnName(1))

        tasksView.append("\n\n")

        tasksView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_ID))))
        tasksView.append("\t\t\t")
        tasksView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_NAME))))

        while (cursor.moveToNext()) {
            tasksView.append("\n\n")
            tasksView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_ID))))
            tasksView.append("\t\t\t")
            tasksView.append((cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_NAME))))
        }
        cursor.close()

    }
}
