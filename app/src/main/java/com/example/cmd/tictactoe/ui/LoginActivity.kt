package com.example.cmd.tictactoe.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cmd.tictactoe.R
import com.example.cmd.tictactoe.presentation_layer.viewModel.LoginViewModel
import com.example.cmd.tictactoe.presentation_layer.viewModel.LoginViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory : LoginViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)

    }
}