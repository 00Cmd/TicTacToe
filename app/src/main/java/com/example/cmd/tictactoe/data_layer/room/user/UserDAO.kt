package com.example.cmd.tictactoe.data_layer.room.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface UserDAO {

    @Query("SELECT * from usersTable where id = :id ")
    fun getUserById(id: Long) : Maybe<User>

    @Query("SELECT * from usersTable")
    fun getAllUsers() : Flowable<List<User>>

    @Insert(onConflict = REPLACE)
    fun insertUser(user : User)


    @Query("DELETE from usersTable")
    fun deleteAllUsers()
}