package com.example.cmd.tictactoe.presentation_layer.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class LoginViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var loginViewProvider: Provider<LoginViewModel>

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return loginViewProvider.get()!! as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}