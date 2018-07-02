package com.example.cmd.tictactoe.injection

import com.example.cmd.tictactoe.LoginActivity
import com.example.cmd.tictactoe.ProfileActivity
import com.example.cmd.tictactoe.RegisterActivity
import com.example.cmd.tictactoe.UserSettingsActivity
import dagger.android.ContributesAndroidInjector

abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeLoginActivity() : LoginActivity

    @ContributesAndroidInjector
    internal abstract fun contributeRegisterActivity() : RegisterActivity

    @ContributesAndroidInjector
    internal abstract fun contributeProfileActivity() : ProfileActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSettingsActivity() : UserSettingsActivity
}