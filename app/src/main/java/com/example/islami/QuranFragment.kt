package com.example.islami

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.islami.databinding.FragmentQuranBinding

class QuranFragment : Fragment() {


    lateinit var myadapter: customAdapter

    lateinit var binding2: FragmentQuranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding2=FragmentQuranBinding.inflate(layoutInflater,container,false)

        return binding2.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myadapter = customAdapter(the_data.sura)
        binding2.recycle.adapter = myadapter

        myadapter.myReferenceinterface = object : customAdapter.myLisnter {
            override fun onClick(suraname: String, index: Int) {

                var myintent = Intent(activity, Sura_details::class.java);

                myintent.putExtra(the_data.key, "${index + 1}.txt")
                myintent.putExtra(the_data.key2,suraname)

                startActivity(myintent)

            }


        }





    }









}