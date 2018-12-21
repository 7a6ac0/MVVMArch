package me.tabacowang.mvvmarch.ui.schedule

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import me.tabacowang.mvvmarch.shared.di.FragmentScoped
import me.tabacowang.mvvmarch.shared.di.ViewModelKey

/**
 * Module where classes needed to create the [ScheduleFragment] are defined.
 */

@Module
internal abstract class ScheduleModule {

    /**
     * Generates an [AndroidInjector] for the [ScheduleFragment].
     */
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeScheduleFragment(): ScheduleFragment

    /**
     * The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [ScheduleViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    abstract fun bindScheduleViewModel(viewModel: ScheduleViewModel): ViewModel
}