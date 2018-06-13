package com.example.cmd.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(),InitFragment {

    var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
    }


    override fun onStart() {
        super.onStart()
        val firebaseUser = mAuth.currentUser
        if (firebaseUser != null) finish() else startFragment(LoginFragment())
    }

    override fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .add(R.id.loginContainer,fragment).commit()
    }
}
