package com.example.cmd.tictactoe.injection

import android.app.Application
import android.arch.persistence.room.Room
import com.example.cmd.tictactoe.data_layer.room.user.UserDAO
import com.example.cmd.tictactoe.data_layer.room.user.UserDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

//    @Provides
//    @Singleton
//    fun provideContext(app : Application) : Application{
//        return app
//    }

    @Singleton
    @Provides
    fun provideDatabase(app : Application) : UserDataBase {
        return Room.databaseBuilder(app,
                UserDataBase::class.java, "user.db")
                .build()
    }

    @Singleton
    @Provides
    fun prodivdeUserDao(db: UserDataBase) : UserDAO {
        return db.userDao()
    }
}