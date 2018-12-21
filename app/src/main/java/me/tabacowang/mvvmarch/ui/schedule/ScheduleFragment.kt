package me.tabacowang.mvvmarch.ui.schedule

import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import me.tabacowang.mvvmarch.MainNavigationFragment
import javax.inject.Inject

class ScheduleFragment : DaggerFragment(), MainNavigationFragment {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var scheduleViewModel: ScheduleViewModel


}