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
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.register_layout.*

class RegisterFragment : Fragment() {

    val TAG : String = "RegistrationFragment"
    var mAuth : FirebaseAuth ? = null
    var databaseInstance : FirebaseDatabase ? = null
    var databaseRef : DatabaseReference ? = null

    companion object {
        fun getInstance() : RegisterFragment {
            return RegisterFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.register_layout,container,false)
        val loginBtn : Button ? = v?.findViewById(R.id.registerLoginBtn)
        val registerBtn : Button ? = v?.findViewById(R.id.registerRegisterBtn)
        init()
        loginBtn?.setOnClickListener { startActivity(Intent(activity,RegisterActivity::class.java)) }
        registerBtn?.setOnClickListener { registerUser() }
        return v
    }

    private fun init() {
        mAuth = FirebaseAuth.getInstance()
        databaseInstance = FirebaseDatabase.getInstance()
        databaseRef = databaseInstance!!.reference.child("users")
    }

    private fun registerUser() {
        val username = userName!!.text.toString()
        val password = userPass!!.text.toString()
        val passConf = userPassConfirm!!.text.toString()

        if (!TextUtils.isEmpty(username) &&
                !TextUtils.isEmpty(password) && !TextUtils.isEmpty(passConf)) {
            if(TextUtils.equals(password,passConf)) {
                mAuth?.createUserWithEmailAndPassword(username, password)?.addOnCompleteListener {
                    task ->
                    if(task.isSuccessful) {

                        val userId = mAuth!!.currentUser!!.providerId
                        val currentUserDb = databaseRef!!.child(userId)
                        currentUserDb.child("username").setValue(username)
                        currentUserDb.child("password").setValue(password)
                        startActivity(Intent(activity,ProfileActivity::class.java))



                    } else Toast.makeText(activity,"Something went wrong",Toast.LENGTH_SHORT).show()
                }
            } else Toast.makeText(activity,"Password did not match .",Toast.LENGTH_SHORT).show()
        } else Toast.makeText(activity,"Please fill all fields",Toast.LENGTH_SHORT).show()
    }
}