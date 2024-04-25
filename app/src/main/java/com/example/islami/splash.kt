package com.example.islami

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)





        try {
            Thread.sleep(500)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } catch (e: InterruptedException) {
            println(e)
        }


    }
}