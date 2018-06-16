package com.example.cmd.tictactoe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

class RegisterActivity : AppCompatActivity(),InitFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        startFragment(RegisterFragment.getInstance())

    }

    override fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.registrationContainer,fragment)
                .addToBackStack("registrationFragment")
                .commit()
    }
}