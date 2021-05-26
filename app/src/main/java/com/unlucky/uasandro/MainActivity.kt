package com.unlucky.uasandro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity(),KontakAdapter.OnItemClickListener {
    private val listKontak = ArrayList<Kontak>()
    private val adapter = KontakAdapter(listKontak ,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listKontak.add(Kontak("Moone","0812777666555",R.mipmap.orang1))
        listKontak.add(Kontak("Ian","0812123456789",R.mipmap.orang2))
        listKontak.add(Kontak("Bryan","0812123456789",R.mipmap.orang4))
        listKontak.add(Kontak("Thor","0812123456789",R.mipmap.orang3))

        val rvKontak = findViewById<RecyclerView>(R.id.rvListKontak)
        rvKontak.layoutManager = LinearLayoutManager(this)

        rvKontak.adapter = adapter




    }

    override fun onItemClick(position: Int) {
        val i = Intent(this,pay_page_activity::class.java);
        startActivity(i)


    }


}