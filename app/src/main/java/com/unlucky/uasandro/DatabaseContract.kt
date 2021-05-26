package com.unlucky.uasandro

import android.provider.BaseColumns

class DatabaseContract {
    object History: BaseColumns{
        const val TABLE_NAME = "History"
        const val COLUMN_NAME_HISTORY = "transfer"

        const val SQL_CREATE_TABLE = "CREATE TABLE ${TABLE_NAME} ("+"${BaseColumns._ID} INTEGER PRIMARY KEY," + "${COLUMN_NAME_HISTORY} TEXT)"
        const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS \${TABLE_NAME}"
    }
}