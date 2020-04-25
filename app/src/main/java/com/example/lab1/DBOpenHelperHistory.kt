package com.example.lab1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class DBOpenHelperHistory(context: Context, factory : SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_HISTORY_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_DATETIME + " DATETIME," +
                COLUMN_NAME_TASKID + " INTEGER" + ")")
        db.execSQL(CREATE_HISTORY_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addHistory(taskId : Int){
        val values = ContentValues()
        val INSERT_HISTORY = ("INSERT INTO $TABLE_NAME ($COLUMN_NAME_DATETIME, $COLUMN_NAME_TASKID VALUES (${LocalDateTime.now()}, $taskId)")
        //values.put(COLUMN_NAME_DATETIME, LocalDateTime.now())

        val db = this.writableDatabase
        //db.insert(TABLE_NAME, null, values)
        db.execSQL(INSERT_HISTORY)
        db.close()
    }
    fun getAllHistory(): Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "MobilesLab3.db"
        val TABLE_NAME = "history"
        val COLUMN_ID = "id"
        val COLUMN_NAME_DATETIME = "datetime"
        val COLUMN_NAME_TASKID = "taskId"
    }
}