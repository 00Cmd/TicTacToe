package com.example.cmd.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.cmd.tictactoe.R.layout.login_layout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_layout.*

class LoginFragment : Fragment() {

    private var mAuth : FirebaseAuth? = null


    companion object {
        fun newInstance() : LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(login_layout,container,false)
        mAuth = FirebaseAuth.getInstance()
        val loginBtn : Button ? = v.findViewById(R.id.loginLoginBtn)
        val registerBtn : Button ? = v.findViewById(R.id.loginRegisterBtn)
        loginBtn?.setOnClickListener { loginUser() }
        registerBtn?.setOnClickListener { redirect() }
        return v
    }

    private fun redirect() {
        startActivity(Intent(activity,RegisterActivity::class.java))
    }

    private fun loginUser() {
        val username = usernameLogin!!.text.toString()
        val userPassword = passwordLogin!!.text.toString()
            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(userPassword)) {
                mAuth?.signInWithEmailAndPassword(username, userPassword)?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(activity, ProfileActivity::class.java))
                    }
                }
            } else {
                Toast.makeText(activity, "Username or password can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }


