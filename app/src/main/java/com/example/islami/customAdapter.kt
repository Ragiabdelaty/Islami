package com.example.islami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class customAdapter(var mylist: List<String>) : RecyclerView.Adapter<customAdapter.Al_VH>() {


    class Al_VH(p: View) : RecyclerView.ViewHolder(p) {
        var TextV: TextView = p.findViewById(R.id.textofsuraname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Al_VH {

        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.customitem, parent, false)

        return Al_VH(view)

    }

    override fun getItemCount(): Int = mylist.size


    override fun onBindViewHolder(holder: Al_VH, position: Int) {

        var element=mylist.get(position)
        holder.TextV.text=element
        if(myReferenceinterface!=null){


            holder.itemView.setOnClickListener {

                myReferenceinterface!!.onClick(element,position)

            }

        }
    }



    interface myLisnter{

        fun onClick(suraname:String,index:Int)

    }

    var myReferenceinterface:myLisnter?=null



}