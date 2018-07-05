package com.example.cmd.tictactoe.presentation_layer.viewModel

import android.arch.lifecycle.ViewModel
import com.example.cmd.tictactoe.data_layer.room.user.UserDAO
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userDAO: UserDAO) : ViewModel() {

}
