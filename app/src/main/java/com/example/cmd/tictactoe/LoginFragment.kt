package com.example.cmd.tictactoe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cmd.tictactoe.R.layout.login_layout

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() : LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(login_layout,container,false)
    }

}