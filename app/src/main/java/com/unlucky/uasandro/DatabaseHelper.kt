package com.unlucky.uasandro

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DatabaseContract.History.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DatabaseContract.History.SQL_DELETE_TABLE)
        onCreate(db)
    }

    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "myhistory.db"
    }

}