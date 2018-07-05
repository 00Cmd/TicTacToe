package com.example.cmd.tictactoe

import android.app.Activity
import android.app.Application
import com.example.cmd.tictactoe.injection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BlogApp : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}