package com.enigmacamp.kts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.btnBack
import kotlinx.android.synthetic.main.activity_third.*

class SecondActivity : AppCompatActivity() {

    val TAG = SecondActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnGotoThirdActivity.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()
        }

        val nameFromMainActivity = intent.getStringExtra("NAME")
        textView.text = "$nameFromMainActivity Welcome to Second Activity"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }
}