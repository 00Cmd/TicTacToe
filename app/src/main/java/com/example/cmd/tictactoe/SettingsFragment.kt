package com.example.cmd.tictactoe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.settings_layout.*

class SettingsFragment : Fragment(),References.AuthRef,References.DbInstance {
    lateinit var userImage: CircleImageView
    lateinit var btnSave: Button
    private val mRef = getDatabaseInstance().getReference("users")
    private val uId = getAuthInstance().currentUser!!.uid



    val TAG = "SettingsFragment"
    companion object {
        fun getInstance() : SettingsFragment {
            return SettingsFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.settings_layout,container,false)
        initialize(v)
        btnSave.setOnClickListener { saveUserSettings() }
        return v
    }

    private fun saveUserSettings() {

        val mUser = User()
        mUser.userId = uId

        //Name validation
        val userName = settingsUserName!!.text.toString()
        val lastName = settingsUserLastname!!.text.toString()
            if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(lastName)) {
                Toast.makeText(activity,
                        "Please fill in your firstname and lastname .", Toast.LENGTH_LONG).show()
            } else  {
                mUser.firstname = userName
                mUser.lastname = lastName
            }


        //Email validation
        val userEmail = settingsUserEmail!!.text.toString()
        val userEmailConf = settingsUserEmailConf!!.text.toString()
        if (!TextUtils.isEmpty(userEmail) && TextUtils.isEmpty(userEmailConf)) {
            Toast.makeText(activity,
                    "Confirmation email can't be empty ! ",Toast.LENGTH_LONG).show()
        } else if (TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userEmailConf)) {
            Toast.makeText(activity,
                    "Both mail fields need to be valid !",Toast.LENGTH_LONG).show()
        } else if (!TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userEmailConf)) {
            if (userEmail == userEmailConf) {
                mUser.email = userEmail
            } else Toast.makeText(activity,"Email does not match !",Toast.LENGTH_SHORT).show()
        }

        //Password validation
        val userPass = settingsUserPassword!!.text.toString()
        val userPassConf = settingsUserPasswordConf!!.text.toString()
        if (!TextUtils.isEmpty(userPass) && TextUtils.isEmpty(userPassConf)) {
            Toast.makeText(activity,
                    "Confirmation password can't be empty ! ",Toast.LENGTH_LONG).show()
        } else if (TextUtils.isEmpty(userPass) && !TextUtils.isEmpty(userPassConf)) {
            Toast.makeText(activity,
                    "Both password fields need to be valid !",Toast.LENGTH_LONG).show()
        } else if(!TextUtils.isEmpty(userPass) && !TextUtils.isEmpty(userPassConf)) {
            if (userPass == userPassConf) {
                mUser.password = userPass
            } else Toast.makeText(activity,"Password does not match !",Toast.LENGTH_SHORT).show()
        }

        mRef.addValueEventListener(initDataChangeListener(mUser))

    }

    private fun initialize(view:View) {
        userImage = view.findViewById(R.id.settingsUserImage)
        if (userImage.drawable == null) {
            Picasso.get().load(R.drawable.avatar).into(userImage)
        }
        btnSave = view.findViewById(R.id.settingsSaveBtn)
    }

    private fun initDataChangeListener(user : User): ValueEventListener {
        val userId = getAuthInstance().currentUser!!.uid
        val dbRef = mRef.child(userId)
        return object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(activity,"error", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                dbRef.setValue(user)
            }
        }
    }
}

