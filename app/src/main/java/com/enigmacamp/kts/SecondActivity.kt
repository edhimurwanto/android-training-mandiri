package com.enigmacamp.kts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity(), CounterHandler {

    val TAG = SecondActivity::class.java.simpleName

    var counter = 0
    lateinit var showCounterFragment: ShowCounterFragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        (counter_fragment_container as CounterFragment).counterHandler = this

        showCounterFragment = ShowCounterFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(counter_fragment_container.id, showCounterFragment)
        fragmentTransaction.commit()
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
}