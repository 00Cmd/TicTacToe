package com.example.cmd.tictactoe.data_layer.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface UserDAO {

    @Query("SELECT * from usersTable where id = :id ")
    fun getUserById(id: Long) : Flowable<User>

    @Query("SELECT * from usersTable")
    fun getAllUsers() : List<User>

    @Insert(onConflict = REPLACE)
    fun insertUser(user : User)


    @Query("DELETE from usersTable")
    fun deleteAllUsers()
}