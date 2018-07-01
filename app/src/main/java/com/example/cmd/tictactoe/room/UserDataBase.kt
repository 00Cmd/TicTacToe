package com.example.cmd.tictactoe.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao() : UserDAO

    companion object {
        private var INSTANCE: UserDataBase? = null
        fun getInstance(context: Context): UserDataBase? {
            if (INSTANCE == null) {
                synchronized(UserDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            UserDataBase::class.java, "user.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() = {
            INSTANCE = null
        }
    }
}