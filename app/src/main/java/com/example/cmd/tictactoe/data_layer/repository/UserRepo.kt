//package com.example.cmd.tictactoe.data_layer.repository
//
//import com.example.cmd.tictactoe.data_layer.room.user.User
//import io.reactivex.Flowable
//import io.reactivex.Maybe
//
//interface UserRepo {
//
//    fun getUserById(id: Long) : Maybe<User>
//
//    fun getAllUsers() : Flowable<List<User>>
//
//    fun insertUser(user : User)
//
//    fun deleteAllUsers()
//}