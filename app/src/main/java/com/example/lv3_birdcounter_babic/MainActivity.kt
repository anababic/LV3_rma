package com.example.lv3_birdcounter_babic

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
        setListeners()
    }

    fun setUI(){
        tvCounter.text = PrefManager().retrieveCounter().toString()
        tvCounter.setBackgroundColor(PrefManager().retrieveBird())
    }

    private fun setListeners() {
        btnBlueBird.setOnClickListener { view-> birdSeen(view) }
        btnGreenBird.setOnClickListener { view-> birdSeen(view) }
        btnRedBird.setOnClickListener { view-> birdSeen(view) }
        btnYellowBird.setOnClickListener { view-> birdSeen(view) }
    }

    private fun birdSeen(view: View?) {
        var counter = PrefManager().retrieveCounter()
        counter = counter + 1
        fun View.getBackgroundColor() = (background as? ColorDrawable?)?.color ?: Color.TRANSPARENT
        val colour = view!!.getBackgroundColor()

        PrefManager().saveBundle(colour,counter)
        setUI()
    }
    
}