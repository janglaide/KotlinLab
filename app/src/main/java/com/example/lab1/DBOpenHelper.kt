package com.example.lab1

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context: Context, factory : SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TASK_TABLE = ("CREATE TABLE " +
                TABLE_NAME_T + "(" +
                COLUMN_ID_T + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_T + " DATETIME" + ")"
                )
        db.execSQL((CREATE_TASK_TABLE))

        val CREATE_HISTORY_TABLE = ("CREATE TABLE " +
                TABLE_NAME_H + "(" +
                COLUMN_ID_H + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_DATETIME + " DATETIME," +
                COLUMN_NAME_TASKID + " INT" + ")")
        db.execSQL(CREATE_HISTORY_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_H")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_T")
        onCreate(db)
    }
    fun getAllHistory():Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME_H", null)
    }
    fun getAllTasks():Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME_T", null)
    }
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "MobilesLab3.db"
        val TABLE_NAME_H = "history"
        val COLUMN_ID_H = "id"
        val COLUMN_NAME_DATETIME = "datetime"
        val COLUMN_NAME_TASKID = "taskId"
        val TABLE_NAME_T = "tasks"
        val COLUMN_ID_T = "id"
        val COLUMN_NAME_T = "name"
    }
}