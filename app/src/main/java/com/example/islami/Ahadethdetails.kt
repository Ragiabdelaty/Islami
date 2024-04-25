package com.example.islami

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.islami.AhadithFragment.HadethsM
import com.example.islami.databinding.ActivityAhadethdetailsBinding

class Ahadethdetails : AppCompatActivity() {


    lateinit var binding4: ActivityAhadethdetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding4 = ActivityAhadethdetailsBinding.inflate(layoutInflater)
        setContentView(binding4.root)

        var hadeths = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("key", HadethsM::class.java)
        } else {
            intent.getSerializableExtra("key") as HadethsM
        }
        binding4.textView.text = hadeths!!.title
        binding4.textView2.text = hadeths!!.content

    }
}