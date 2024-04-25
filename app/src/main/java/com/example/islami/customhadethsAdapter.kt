package com.example.islami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.AhadithFragment.HadethsM

class customhadethsAdapter(var mylist2: List<HadethsM>) :
    RecyclerView.Adapter<customhadethsAdapter.theVH>() {


    class theVH(item: View) : RecyclerView.ViewHolder(item) {

        var TextV:TextView=item.findViewById(R.id.textofsuraname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): theVH {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.customitem, parent, false)

        return theVH(v)


    }

    override fun getItemCount(): Int = mylist2.size

    override fun onBindViewHolder(holder: theVH, position: Int) {

        var title=mylist2.get(position).title
        holder.TextV.text=title
        if(myReferenceinterface!=null){


            holder.itemView.setOnClickListener {

                myReferenceinterface!!.onClick(mylist2[position],position)

            }

        }

    }

    interface myLisnter{

        fun onClick(hadeths:HadethsM,index:Int)

    }

    var myReferenceinterface:myLisnter?=null






}