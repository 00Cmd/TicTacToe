package com.example.cmd.tictactoe.injection

import com.example.cmd.tictactoe.presentation_layer.viewModel.LoginViewModel
import com.example.cmd.tictactoe.ui.LoginActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun provideLoginActivityViewModel() : LoginActivity

}