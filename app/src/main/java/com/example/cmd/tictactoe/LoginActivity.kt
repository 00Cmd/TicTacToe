package com.example.cmd.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(),InitFragment {

    var mAuth : FirebaseAuth ? = null  //FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        mAuth = FirebaseAuth.getInstance()
    }


    override fun onStart() {
        super.onStart()
        val firebaseUser = mAuth!!.currentUser
        if (firebaseUser != null) startActivity(Intent(this,ProfileActivity::class.java)) else startFragment(LoginFragment.newInstance())
    }

    override fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.loginContainer,fragment)
                .addToBackStack("loginFragment")
                .commit()
    }
}
