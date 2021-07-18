package com.enigmacamp.kts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        btnBack.setOnClickListener {
           finish()
        }

        btnSendMessage.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Welcome to Message Screen")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Send message to. . ."))
        }
    }


}