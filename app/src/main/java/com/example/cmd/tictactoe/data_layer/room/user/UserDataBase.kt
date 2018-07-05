package com.example.cmd.tictactoe.data_layer.room.user

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao() : UserDAO

    companion object {
        @Volatile private var INSTANCE: UserDataBase? = null
        fun getInstance(context: Context): UserDataBase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        fun destroyInstance() = {
            INSTANCE = null
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        UserDataBase::class.java,
                        "user.db")
                        .build()

    }
}