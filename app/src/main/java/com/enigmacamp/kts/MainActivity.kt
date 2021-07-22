package com.enigmacamp.kts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CounterHandler {

    val TAG = MainActivity::class.java.simpleName

    var counter = 0
    lateinit var showCounterFragment: ShowCounterFragment
    lateinit var counterFragment: CounterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate()")

        showCounterFragment = ShowCounterFragment()
        counterFragment = CounterFragment()

        switchFragment(counterFragment)

        btnCounterFragment.setOnClickListener {
            switchFragment(counterFragment)
        }

        btnShowCounterFragment.setOnClickListener {
            switchFragment(showCounterFragment)
        }

    }

    fun switchFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        when(fragment){
            is ShowCounterFragment -> {
                Log.d(TAG, "Active Fragment is ShowCounterFragment")
                fragmentTransaction.replace(counter_fragment_container.id, fragment)
                counterFragment.setFragmentResult("COUNTER", bundleOf("counter" to counter))
//                counterFragment.setResult(this.counter)
                fragmentTransaction.commit()
            }

            else -> {
                Log.d(TAG, "Active Fragment is CounterFragment")
                (fragment as CounterFragment).counterHandler = this
                fragmentTransaction.replace(counter_fragment_container.id, fragment)
                fragmentTransaction.commit()
            }
        }
    }

    override fun handleIncrement(){
        this.counter++
        Log.d(TAG, this.counter.toString())
    }

    override fun handleDecrement(){
        this.counter--
        Log.d(TAG, this.counter.toString())
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