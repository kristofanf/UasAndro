package com.unlucky.uasandro

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact.view.*


class KontakAdapter ( val listKontak: ArrayList<Kontak>, private val listener: OnItemClickListener): RecyclerView.Adapter<KontakAdapter.KontakHolder>()
{
    inner class KontakHolder(val v: View): RecyclerView.ViewHolder(v), View.OnClickListener{
       val imageView : ImageView = v.findViewById(R.id.ivFoto)
        val nama : TextView = v.findViewById(R.id.tvNama)
        val no : TextView = v.findViewById(R.id.tvNoHp)

        init {

            v.setOnClickListener{
                val intent = Intent(v.context,pay_page_activity::class.java)
                val nama1= nama.text.toString()
                val no1= no.text.toString()
                intent.putExtra("username",nama1)
                intent.putExtra("no",no1)
                v.context.startActivity(intent)
            }


        }

        override fun onClick(v: View?) {
            val position = adapterPosition

                listener.onItemClick(position)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): KontakAdapter.KontakHolder{
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.contact,parent,false)
        return KontakHolder(v)
    }

    override fun onBindViewHolder(holder: KontakAdapter.KontakHolder,position: Int){
        val currentItem = listKontak[position]
        holder.imageView.setImageResource(currentItem.cover)
        holder.nama.text = currentItem.nama
        holder.no.text = currentItem.No



    }

    override fun getItemCount(): Int{
        return listKontak.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}



