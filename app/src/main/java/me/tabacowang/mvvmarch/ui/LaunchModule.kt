package me.tabacowang.mvvmarch.ui

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.tabacowang.mvvmarch.shared.di.ViewModelKey

/**
 * Module where classes needed for app launch are defined.
 */
@Module
internal abstract class LaunchModule {

    /**
     * The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [LaunchViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(LaunchViewModel::class)
    internal abstract fun bindLaunchViewModel(viewModel: LaunchViewModel): ViewModel
}