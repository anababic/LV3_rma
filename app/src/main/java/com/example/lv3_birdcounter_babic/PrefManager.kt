package com.example.lv3_birdcounter_babic

import android.content.Context

class PrefManager {

    companion object {
        val PREFS_FILE = "MyPreferences"
        val PREFS_COUNTER = "MyCounter"
        val PREFS_KEY_BIRD = "Colour"
    }

    fun saveBundle(bird: Int, counter:Int) {
        val sharedPreferences = BirdCounter.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_BIRD, bird)
        editor.putInt(PREFS_COUNTER, counter);
        editor.apply()
    }

    fun retrieveBird(): Int {
        val sharedPreferences = BirdCounter.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getInt(PREFS_KEY_BIRD,0)
    }


    fun retrieveCounter():Int{
        val sharedPreferences = BirdCounter.ApplicationContext.getSharedPreferences(PREFS_FILE,
            Context.MODE_PRIVATE);
        return sharedPreferences.getInt(PREFS_COUNTER,0);
    }
}