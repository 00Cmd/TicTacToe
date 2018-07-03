package com.example.cmd.tictactoe.injection

import android.app.Application
import android.arch.persistence.room.Room
import com.example.cmd.tictactoe.data_layer.room.UserDAO
import com.example.cmd.tictactoe.data_layer.room.UserDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Singleton
    @Provides
    fun providesUserDb(app: Application) : UserDataBase {
        return Room.databaseBuilder(app,UserDataBase::class.java,"user.db").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db : UserDataBase) : UserDAO = db.userDao()
}
