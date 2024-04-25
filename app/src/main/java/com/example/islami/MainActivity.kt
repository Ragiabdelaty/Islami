package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startfragment(QuranFragment())


        binding.naview.setOnItemSelectedListener {


            if (it.itemId == R.id.quran) {
                startfragment(QuranFragment())

            } else if (it.itemId == R.id.Ahadith) {
                startfragment(AhadithFragment())


            } else if (it.itemId == R.id.Sabha) {

                startfragment(SabhaFragment())

            } else if (it.itemId == R.id.Radio) {
                startfragment(RadioFragment())


            }

            return@setOnItemSelectedListener true
        }





    }

    private fun startfragment(frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.framebox, frag).commit()
    }
}