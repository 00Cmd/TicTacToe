//package com.example.cmd.tictactoe.presentation_layer.viewModel
//
//import android.arch.lifecycle.ViewModel
//import com.example.cmd.tictactoe.data_layer.repository.UserRepo
//import com.example.cmd.tictactoe.data_layer.repository.UserRepoImpl
//import com.example.cmd.tictactoe.data_layer.room.user.User
//import io.reactivex.Flowable
//import io.reactivex.Maybe
//import io.reactivex.disposables.CompositeDisposable
//
//class UserViewModel(val userRepo : UserRepo, val disposable: CompositeDisposable) : ViewModel() {
//
//    fun getUserById(id: Long): Maybe<User> {
//        return userRepo.getUserById(id)
//    }
//
//    fun getAllUsers(): Flowable<List<User>> {
//        return userRepo.getAllUsers()
//    }
//
//    fun insertUser(user: User) {
//        userRepo.insertUser(user)
//    }
//
//    fun deleteAllUsers() {
//        userRepo.deleteAllUsers()
//    }
//
//    override fun onCleared() {
//        //prevents memory leaks by disposing pending observable objects
//        if (disposable != null && !disposable.isDisposed) {
//            disposable.clear();
//        }    }
//}