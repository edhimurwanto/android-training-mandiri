package com.enigmacamp.kts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_counter.*
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

class CounterFragment(var counterHandler: CounterHandler? = null) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonIncrease.setOnClickListener {
            counterHandler?.handleIncrement()
        }

        buttonDecrease.setOnClickListener {
            counterHandler?.handleDecrement()
        }
    }

    fun setResult(counter: Int){
        Log.d("COUNTER", "Di SET $counter")
        setFragmentResult("COUNTER", bundleOf("counter" to counter))
    }

}