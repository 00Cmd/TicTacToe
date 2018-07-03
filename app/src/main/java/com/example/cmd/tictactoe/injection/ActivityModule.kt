package com.example.cmd.tictactoe.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeLoginActivity() : LoginActivity
}