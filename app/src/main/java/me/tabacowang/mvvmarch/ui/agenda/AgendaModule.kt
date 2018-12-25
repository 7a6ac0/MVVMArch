package me.tabacowang.mvvmarch.ui.agenda

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import me.tabacowang.mvvmarch.shared.di.FragmentScoped
import me.tabacowang.mvvmarch.shared.di.ViewModelKey

/**
 * Module where classes needed to create the [AgendaFragment] are defined.
 */
@Module
internal abstract class AgendaModule {

    /**
     * Generates an [AndroidInjector] for the [AgendaFragment].
     */
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeAgendaFragment(): AgendaFragment

    /**
     * The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [AgendaViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(AgendaViewModel::class)
    abstract fun bindAgendaViewModel(viewModel: AgendaViewModel): ViewModel

}