package com.example.cmd.tictactoe

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

class UserSettingsActivity : AppCompatActivity(),InitFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        startFragment(SettingsFragment.getInstance())
    }
    override fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .add(R.id.userSettingsContainer,fragment)
                .addToBackStack("userSettingsFragment").commit()
    }
}