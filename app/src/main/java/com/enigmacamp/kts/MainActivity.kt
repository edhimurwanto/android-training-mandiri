package com.enigmacamp.kts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CounterHandler {

    val TAG = MainActivity::class.java.simpleName

    var counter = 0
    lateinit var showCounterFragment: ShowCounterFragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate()")

        (counter_fragment_container as CounterFragment).counterHandler = this

        showCounterFragment = ShowCounterFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(show_counter_fragment_container.id, showCounterFragment)
        fragmentTransaction.commit()

        btnGoToSecondActivity.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun handleIncrement(){
        this.counter++
        Log.d(TAG, this.counter.toString())
        showCounterFragment.updateCounter(this.counter)
    }

    override fun handleDecrement(){
        this.counter--
        Log.d(TAG, this.counter.toString())
        showCounterFragment.updateCounter(this.counter)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNTER", this.counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            this.counter = savedInstanceState.getInt("COUNTER")
            Log.d(TAG, this.counter.toString())
            showCounterFragment.updateCounter(this.counter)
    }
}