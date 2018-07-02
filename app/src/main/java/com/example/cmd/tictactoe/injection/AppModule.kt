package com.example.cmd.tictactoe.injection

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.cmd.tictactoe.room.UserDAO
import com.example.cmd.tictactoe.room.UserDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    //Prodive database, network connection here
    @Singleton
    @Provides
    fun providesDatabase(app: Application): UserDataBase {
        return Room.databaseBuilder(app,RoomDatabase::class.java,"user.db")
                .build() as UserDataBase
    }

    @Singleton
    @Provides
    fun providesUserDao(db: UserDataBase): UserDAO {
        return db.userDao()
    }
}