package com.example.cmd.tictactoe.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface UserDAO {
    @Query("SELECT * from usersTable")
    fun getAll() : List<User>

    @Insert(onConflict = REPLACE)
    fun insert(user : User)


    @Query("DELETE from usersTable")
    fun deleteAll()
}