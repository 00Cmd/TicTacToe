//package com.example.cmd.tictactoe.data_layer.repository
//
//import com.example.cmd.tictactoe.data_layer.room.user.User
//import com.example.cmd.tictactoe.data_layer.room.user.UserDAO
//import io.reactivex.Flowable
//import io.reactivex.Maybe
//import javax.inject.Inject
//
//class UserRepoImpl @Inject constructor(private val userDao : UserDAO) : UserRepo {
//
//
//    override fun getUserById(id: Long): Maybe<User> {
//         return userDao.getUserById(id)
//    }
//
//    override fun getAllUsers(): Flowable<List<User>> {
//        return userDao.getAllUsers()
//    }
//
//    override fun insertUser(user: User) {
//        userDao.insertUser(user)
//    }
//
//    override fun deleteAllUsers() {
//        userDao.deleteAllUsers()
//    }
//}