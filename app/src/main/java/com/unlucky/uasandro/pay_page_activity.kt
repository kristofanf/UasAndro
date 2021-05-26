package com.unlucky.uasandro

import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import android.widget.Button
import android.widget.EditText
import com.unlucky.uasandro.MainActivity

import android.widget.TextView
import kotlinx.android.synthetic.main.pay_page.*

class pay_page_activity :  AppCompatActivity(){
    lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pay_page)
        val dbHelper = DatabaseHelper(this)
        db = dbHelper.writableDatabase
        var intent = intent
        val nama = intent.getStringExtra("username")
        val no = intent.getStringExtra("no")


       val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        val tampilNama = findViewById<TextView>(R.id.tvNama)
        val tampilNo = findViewById<TextView>(R.id.tvNoHp)

        tampilNama.text = nama
        tampilNo.text = no
        btnConfirm.setOnClickListener{
            saveData(etTotal.text.toString())
            setContentView(R.layout.konfirmasi)
        }
    }
    fun saveData(total:String){
        val values = ContentValues().apply {
            put(DatabaseContract.History.COLUMN_NAME_HISTORY,total)
        }
        db.insert(DatabaseContract.History.TABLE_NAME,null,values)
    }

}