package me.tabacowang.mvvmarch.ui.scheduledetail

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
internal abstract class ScheduleDetailModule {

    /**
     * Generates an [AndroidInjector] for the [ScheduleDetailFragment].
     */
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeScheduleDetailFragment(): ScheduleDetailFragment

    /**
     * The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [ScheduleDetailViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(ScheduleDetailViewModel::class)
    abstract fun bindScheduleDetailViewModel(viewModel: ScheduleDetailViewModel): ViewModel
}