package com.example.cmd.tictactoe.injection

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

class BlogApp  : Application(), HasActivityInjector {

    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

//        DaggerAppComponent.builder().application(blogApp).build.inject(blogApp)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}