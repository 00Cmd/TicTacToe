//package com.example.cmd.tictactoe.presentation_layer.viewModel
//
//import android.arch.lifecycle.ViewModel
//import android.arch.lifecycle.ViewModelProvider
//import com.example.cmd.tictactoe.data_layer.repository.UserRepoImpl
//import javax.inject.Inject
//import io.reactivex.disposables.CompositeDisposable
//import javax.inject.Named
//
//
//class UserViewModelFactory : ViewModelProvider.Factory {
//
//    @Inject
//    lateinit var userRepoImpl: UserRepoImpl
//
//    @Inject
//    @Named("vm")
//    lateinit var compositeDisposable: CompositeDisposable
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
//            return UserViewModel(userRepoImpl, compositeDisposable) as T
//        } else throw IllegalArgumentException("Wrong ViewModel class")
//    }
//}