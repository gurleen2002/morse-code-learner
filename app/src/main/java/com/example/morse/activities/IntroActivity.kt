package com.example.morse.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.morse.R

class IntroActivity : AppCompatActivity() {
    private val mContext = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val buttonView = findViewById<Button>(R.id.start)
        buttonView.setOnClickListener {
            val intent = Intent(mContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}