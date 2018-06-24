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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.register_layout.*

class RegisterFragment : Fragment(),References.AuthRef,References.DbInstance {

    val TAG : String = "RegistrationFragment"
    lateinit var databaseRef : DatabaseReference

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
        databaseRef = getDatabaseInstance().getReference("users")
    }

    private fun registerUser() {
        val username = userName!!.text.toString()
        val password = userPass!!.text.toString()
        val passConf = userPassConfirm!!.text.toString()
        val authInstance = getAuthInstance()

        if (!TextUtils.isEmpty(username) &&
                !TextUtils.isEmpty(password) && !TextUtils.isEmpty(passConf)) {
            if(TextUtils.equals(password,passConf)) {
                if (password.length > 5) {
                    authInstance.createUserWithEmailAndPassword(username, password).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val userId = authInstance.currentUser!!.uid
                            val currentUserDb = databaseRef.child(userId)
                            val mUser = User(username,"","",password,"",userId)
                            currentUserDb.setValue(mUser)
                            UserHolder.getInstance().addUser(mUser)
                            startActivity(Intent(activity, UserSettingsActivity::class.java))
                        } else Toast.makeText(activity, "Something went wrong. Is the email valid?", Toast.LENGTH_SHORT).show()
                    }
                } else Toast.makeText(activity,"Password must be at least 6 characters long.",Toast.LENGTH_SHORT).show()
            } else Toast.makeText(activity,"Password did not match .",Toast.LENGTH_SHORT).show()
        } else Toast.makeText(activity,"Please fill all fields",Toast.LENGTH_SHORT).show()
    }
}