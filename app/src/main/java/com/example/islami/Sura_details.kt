package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.islami.databinding.ActivitySuraDetailsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class Sura_details : AppCompatActivity() {

    lateinit var binding3: ActivitySuraDetailsBinding
    lateinit var filename: String

    lateinit var suraName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding3.root)
        filename = intent.getStringExtra(the_data.key)!!

        suraName = intent.getStringExtra(the_data.key2)!!

        // Toast.makeText(this,"${suraName}",Toast.LENGTH_LONG).show()

        binding3.Tv1.text = suraName
        binding3.textView2.text = readfiles()


    }

    private fun readfiles(): String {
        var filecontent = ""

        try {

            val inputstream = assets.open(filename)

            val reader = BufferedReader(InputStreamReader(inputstream))

            val filelines: List<String> = reader.readLines()

            filecontent = filelines.joinToString(separator = " ") {
                val index = filelines.indexOf(it) + 1
                return@joinToString it + "{${index}}"


            }
            inputstream.close()

        } catch (e: Exception) {


        }

return filecontent
    }
}