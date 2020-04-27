package com.example.lab1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.lab1.Entities.Task

class DBOpenHelperTask(context: Context, factory : SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TASK_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " DATETIME" + ")"
                )
        db.execSQL((CREATE_TASK_TABLE))

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addTask(task: Task){
        val values = ContentValues()
        values.put(COLUMN_NAME, task.description)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
    fun getAllTasks():Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
    @SuppressLint("Recycle")
    fun getTask(id: Int): String{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT $COLUMN_NAME FROM $TABLE_NAME WHERE id = $id", null)
        cursor!!.moveToFirst()
        val tmp = (cursor.getString(cursor.getColumnIndex(DBOpenHelperTask.COLUMN_NAME)))
        return tmp
    }
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MobilesLab3.db"
        const val TABLE_NAME = "tasks"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }
}