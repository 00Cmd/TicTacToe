package com.example.cmd.tictactoe.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build() : AppComponent
        @BindsInstance
        fun application(application : Application) : Builder
    }

    fun inject(blogApp: BlogApp)
}