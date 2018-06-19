package com.example.cmd.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cmd.tictactoe.R.layout.profile_layout

class ProfileFragment : Fragment(),References.AuthRef {
    val TAG = "ProfileFragment"
    companion object {
        fun getInstance() : ProfileFragment {
            return ProfileFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(profile_layout,container,false)

    }



}